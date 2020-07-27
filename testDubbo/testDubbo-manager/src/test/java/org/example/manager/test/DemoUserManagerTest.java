package org.example.manager.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.example.manager.DemoUserManager;
import org.example.manager.test.base.BaseRollbackTest;
import org.example.model.DemoUser;

public class DemoUserManagerTest extends BaseRollbackTest {
	@Autowired
	private DemoUserManager demoUserManager;
	
	@Test
	public void testSelect(){
		DemoUser user = demoUserManager.selectByPrimaryKey(1);
		Assert.assertEquals(1, user.getId().intValue());
	}
	
	@Test
	public void testInsert(){
		DemoUser user =new DemoUser();
		user.setCode("698533");
		user.setComment("平台架构");
		user.setDescription("编程的码农");
		user.setName("xyc");
		user.setId(10001);
		demoUserManager.insert(user);
		DemoUser user1 = demoUserManager.selectByPrimaryKey(10001);
		Assert.assertEquals(10001, user1.getId().intValue());
	}
	
	@Test
	public void testUpdate(){
		DemoUser user = demoUserManager.selectByPrimaryKey(1);
		user.setComment("111111");
		demoUserManager.updateByPrimaryKey(user);
		DemoUser user1 = demoUserManager.selectByPrimaryKey(1);
		Assert.assertEquals("111111", user1.getComment());
	}
	
	@Test
	public void testDelete(){
		demoUserManager.deleteByPrimaryKey(1);
		DemoUser user = demoUserManager.selectByPrimaryKey(1);
		Assert.assertEquals(null, user);
	}
}
