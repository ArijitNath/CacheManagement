package org.midas.analytics.simplecache.services;

import org.midas.analytics.simplecache.model.JwtLogin;
import org.midas.analytics.simplecache.model.Response;

public interface JWTCacheService {
	Response put(JwtLogin jwtLogin);
	Response get (String userName);
	Response delete(JwtLogin jwtLogin);
}
