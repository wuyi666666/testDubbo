package org.example.dao.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.example.dao.test.base.BaseRollbackTest;
import org.example.mapper.DemoUserMapper;
import org.example.model.DemoUser;
import org.example.model.extend.DemoUserExtend;

/**
 * DemoUser表单元测试
 * @author 698533
 *
 */
public class DemoUserTest extends BaseRollbackTest{
	
	@Autowired
	private DemoUserMapper demoUserMapper;
	
	@Test
	public void testSelect(){
		DemoUser user = demoUserMapper.selectByPrimaryKey(1);
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
		demoUserMapper.insert(user);
		DemoUser user1 = demoUserMapper.selectByPrimaryKey(10001);
		Assert.assertEquals(10001, user1.getId().intValue());
	}
	
	@Test
	public void testUpdate(){
		DemoUser user = demoUserMapper.selectByPrimaryKey(1);
		user.setComment("111111");
		demoUserMapper.updateByPrimaryKey(user);
		DemoUser user1 = demoUserMapper.selectByPrimaryKey(1);
		Assert.assertEquals("111111", user1.getComment());
	}
	
	@Test
	public void testDelete(){
		demoUserMapper.deleteByPrimaryKey(1);
		DemoUser user = demoUserMapper.selectByPrimaryKey(1);
		Assert.assertEquals(null, user);
	}
	
	/**
	 * 自定义扩展方法测试
	 */
	@Test
	public void testSelectAll(){
		List<DemoUserExtend> list = demoUserMapper.selectAll();
		if(list.size() > 0){
			DemoUserExtend userExt = list.get(0);
			System.out.println(userExt.getDemoLevel()+" "+userExt.getDemoLevelName());
			Assert.assertEquals(1,userExt.getId().intValue());
		}
	}

}
