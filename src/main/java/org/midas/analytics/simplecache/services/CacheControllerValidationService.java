package org.midas.analytics.simplecache.services;

import org.midas.analytics.simplecache.model.JwtLogin;
import org.midas.analytics.simplecache.model.Response;

public interface CacheControllerValidationService {
	Response save(JwtLogin jwtLogin);
	Response get(JwtLogin jwtLogin);
	Response delete(JwtLogin jwtLogin);
}
