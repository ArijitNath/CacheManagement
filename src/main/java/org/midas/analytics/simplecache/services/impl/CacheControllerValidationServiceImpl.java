package org.midas.analytics.simplecache.services.impl;

import java.security.NoSuchAlgorithmException;

import org.midas.analytics.simplecache.constants.ErrorCodes;
import org.midas.analytics.simplecache.model.JwtLogin;
import org.midas.analytics.simplecache.model.Response;
import org.midas.analytics.simplecache.services.CacheControllerValidationService;
import org.midas.analytics.simplecache.services.JWTCacheService;
import org.midas.analytics.simplecache.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheControllerValidationServiceImpl implements CacheControllerValidationService {
	
	@Autowired 
	private JWTCacheService jwtCacheService;

	@Override
	public Response save(JwtLogin jwtLogin) {
		Response response = new Response();
		
		try {
			if (EncryptionUtil.isEncryptionValid(jwtLogin.getUserName()))
				response = jwtCacheService.put(jwtLogin);
		} catch (NoSuchAlgorithmException e) {
			response.setStatusCode(ErrorCodes.JWT_INVALID_USER_ACCESS_CODE);
			response.setStatusMessage(ErrorCodes.JWT_INVALID_USER_ACCESS_MESSAGE);
		}
		
		return response;
	}

	@Override
	public Response get(JwtLogin jwtLogin) {
		Response response = new Response();
		
		try {
			if (EncryptionUtil.isEncryptionValid(jwtLogin.getUserName()))
				response = jwtCacheService.get(jwtLogin.getUserName());
		} catch (NoSuchAlgorithmException e) {
			response.setStatusCode(ErrorCodes.JWT_INVALID_USER_ACCESS_CODE);
			response.setStatusMessage(ErrorCodes.JWT_INVALID_USER_ACCESS_MESSAGE);
		}
		
		return response;
	}

	@Override
	public Response delete(JwtLogin jwtLogin) {
		Response response = new Response();
		
		try {
			if (EncryptionUtil.isEncryptionValid(jwtLogin.getUserName()))
				response = jwtCacheService.delete(jwtLogin);
		} catch (NoSuchAlgorithmException e) {
			response.setStatusCode(ErrorCodes.JWT_INVALID_USER_ACCESS_CODE);
			response.setStatusMessage(ErrorCodes.JWT_INVALID_USER_ACCESS_MESSAGE);
		}
		
		return response;
	}
}
