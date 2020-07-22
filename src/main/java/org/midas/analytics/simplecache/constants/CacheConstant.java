package org.midas.analytics.simplecache.constants;

public interface CacheConstant {
	String CACHE_MAPPING = "/cache";
	String SAVE_MAPPING = "/save";
	String GET_MAPPING = "/get/{username}";
	String DELETE_MAPPING = "/delete";
	
	String LoginCache = "LoginCache";
	String LRU = "LRU";
		
	int MAX_CACHE_ENTRIES = 1000;
	int TIME_TO_LIVE_JWT = 1000 * 60 * 60 * 60;
	
	String KEYSPACE = "employee_analytics";
	
	String SHA_256 = "SHA-256";
	String SALT = "SHA1PRNG";
}
