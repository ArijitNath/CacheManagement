package org.midas.analytics.simplecache.services.impl;

import org.midas.analytics.simplecache.constants.CacheConstant;
import org.midas.analytics.simplecache.constants.ErrorCodes;
import org.midas.analytics.simplecache.model.JwtDetails;
import org.midas.analytics.simplecache.model.JwtLogin;
import org.midas.analytics.simplecache.model.Response;
import org.midas.analytics.simplecache.repository.JwtRepository;
import org.midas.analytics.simplecache.services.JWTCacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class JWTCacheServiceImpl implements JWTCacheService {
	
	private JwtRepository jwtRepository;
	
	public JWTCacheServiceImpl(JwtRepository jwtRepository) {
		this.jwtRepository = jwtRepository;
	}
	
	@Override
	@Cacheable ( value = CacheConstant.LoginCache, key = "'JWTCache'+#jwtLogin", condition = "#jwtLogin != null" )
	public Response put(JwtLogin jwtLogin) {
		
		Response response = new Response();
		
		try {
			JwtDetails jwtDetails = new JwtDetails(jwtLogin.getUserName(), jwtLogin.getJwt(), Boolean.TRUE);
			response.setJwtDetails(jwtDetails);
			jwtRepository.save(jwtDetails);
			response.setStatusCode(ErrorCodes.SUCCESS_CODE);
			response.setStatusMessage(ErrorCodes.SUCCESS_MESSAGE);
		}
		catch (Exception e) {
			response.setStatusCode(ErrorCodes.JWT_SAVE_ERROR_CODE);
			response.setStatusMessage(ErrorCodes.JWT_SAVE_ERROR_MESSAGE + " " + e.getMessage());
		}
		
		return response;
	}

	@Override
	@Cacheable (value = CacheConstant.LoginCache, key = "'JWTCache'+#userName", condition = "#userName != null" )
	public Response get(String userName) {
		
		Response response = new Response();
		
		try {
			JwtDetails jwtDetails = jwtRepository.findById(userName).get();
			
			if (jwtDetails.isActive()) {
				response.setJwtDetails(jwtDetails);
				response.setStatusCode(ErrorCodes.SUCCESS_CODE);
				response.setStatusMessage(ErrorCodes.SUCCESS_MESSAGE);
			}
			else {
				response.setStatusCode(ErrorCodes.JWT_INACTIVE_ERROR_CODE);
				response.setStatusMessage(ErrorCodes.JWT_INACTIVE_ERROR_MESSAGE);
			}
		}
		catch(Exception e) {
			response.setStatusCode(ErrorCodes.JWT_FETCH_ERROR_CODE);
			response.setStatusMessage(ErrorCodes.JWT_FETCH_ERROR_MESSAGE + " " + e.getMessage());
		}
		
		return response;			
	}

	
	@Override
	@CacheEvict( value = CacheConstant.LoginCache, key = "'JWTCache'+#userName", condition = "#userName != null" )
	public Response delete(JwtLogin jwtLogin) {
		Response response = new Response();
		
		try {
			JwtDetails jwtDetails = new JwtDetails(jwtLogin.getUserName(), jwtLogin.getJwt(), Boolean.FALSE);
			response.setJwtDetails(jwtDetails);
			jwtRepository.save(jwtDetails);
			response.setStatusCode(ErrorCodes.SUCCESS_CODE);
			response.setStatusMessage(ErrorCodes.SUCCESS_MESSAGE);
		}
		catch (Exception e) {
			response.setStatusCode(ErrorCodes.JWT_DEACTIVATE_ERROR_CODE);
			response.setStatusMessage(ErrorCodes.JWT_DEACTIVATE_ERROR_MESSAGE + " " + e.getMessage());
		}
		
		return response;
	}
}
