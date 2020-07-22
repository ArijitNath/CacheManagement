package org.midas.analytics.simplecache.cacheconfig;

import org.midas.analytics.simplecache.constants.CacheConstant;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class EHCacheConfig extends CachingConfigurerSupport {

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}
	
	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		net.sf.ehcache.config.Configuration cacheConfig = new net.sf.ehcache.config.Configuration();
		cacheConfig.addCache(jwtCacheConfig());
		
		return net.sf.ehcache.CacheManager.newInstance(cacheConfig);
	}
	
	private CacheConfiguration jwtCacheConfig() {
		CacheConfiguration loginJWTCache = new CacheConfiguration();
		loginJWTCache.setName(CacheConstant.LoginCache);
		loginJWTCache.setMemoryStoreEvictionPolicy(CacheConstant.LRU);
		//loginJWTCache.internalSetMaxEntriesInCache(CacheConstant.MAX_CACHE_ENTRIES);
		loginJWTCache.setTimeToLiveSeconds(CacheConstant.TIME_TO_LIVE_JWT);
		loginJWTCache.setMaxBytesLocalHeap(1000L);
		
		return loginJWTCache;
	}
}
