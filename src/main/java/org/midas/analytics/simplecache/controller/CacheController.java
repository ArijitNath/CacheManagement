package org.midas.analytics.simplecache.controller;

import org.midas.analytics.simplecache.constants.CacheConstant;
import org.midas.analytics.simplecache.model.JwtLogin;
import org.midas.analytics.simplecache.model.Response;
import org.midas.analytics.simplecache.services.JWTCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = CacheConstant.CACHE_MAPPING )
public class CacheController {
	
	@Autowired 
	private JWTCacheService jwtCacheService;

	@PostMapping(value = CacheConstant.SAVE_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response save(@RequestBody JwtLogin jwtLogin) {
		return jwtCacheService.put(jwtLogin);
	}
	
	@GetMapping(value = CacheConstant.GET_MAPPING)
	public Response put(@PathVariable("username") String userName) {
		return jwtCacheService.get(userName);
	}
	
	@DeleteMapping(value = CacheConstant.DELETE_MAPPING)
	public Response delete(@RequestBody JwtLogin jwtLogin) {
		return jwtCacheService.delete(jwtLogin);
	}
}
