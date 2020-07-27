package org.example.manager.test;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import com.sf.framework.cache.IRedisCache;
import org.example.manager.test.base.BaseRollbackTest;

@ContextConfiguration(locations = "classpath*:test-redis.xml")
public class RedisTest extends BaseRollbackTest{
	
	@Autowired
    @Qualifier("redisCache")
    private IRedisCache<String, String> redisCache;

	@Test
	public void testAddRedis(){
		redisCache.add("template", "TestRedis");
		//注意：get的时候不要加配置时的那个fnq,框架底层默认加上
		String val = redisCache.get("template");
		Assert.assertEquals("TestRedis",val);
	}
}
