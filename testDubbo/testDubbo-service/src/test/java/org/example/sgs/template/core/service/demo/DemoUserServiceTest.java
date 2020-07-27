package org.example.sgs.template.core.service.demo;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sf.framework.domain.Result;
import com.sf.framework.utils.ConvertDomainUtils;
import org.example.model.DemoUser;
import org.example.service.DemoUserRestService;
import org.example.service.DemoUserService;

/**
 * 测试用例直接右击即可执行
 * @author 698533
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:test-service.xml" )
public class DemoUserServiceTest extends AbstractJUnit4SpringContextTests{
	
	private static final String REQUEST_HTTP_URL = "http://localhost:8888/services";

	@Autowired
	private DemoUserService demoUserService;
	
	@Autowired
	private DemoUserRestService demoUserRestService;

	@Test
	public void testRpcSelectService(){
		Result<DemoUser> result = demoUserService.selectByPrimaryKey(1);
		Assert.assertEquals(1, result.getObj().getId().intValue());
	}

	@Test
	public void testRpcAddervice(){
		DemoUser user = new DemoUser();
		user.setLanguage("en_US");
		user.setCode("698533");
		user.setId(111111);
		user.setComment("1111111");
		user.setDescription("2222222");
		user.setName("1");
		try {
			Result<Integer> result1 = demoUserService.insert(user);
			System.out.println(result1.getErrorMessage());
		} catch(Exception e){
			System.out.println(e);
		}finally{
			Result<Integer> result2 = demoUserService.deleteByPrimaryKey(111111);
		}
	}
	
	@Test
	public void testHttpGetSelect(){
		String url = REQUEST_HTTP_URL + "/demoUser/selectByPrimaryKey/1";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
            Assert.assertEquals(200, response.getStatus());
        } finally {
            response.close();
            client.close();
        }
	}
	
	@Test
	public void testHttpPostInsert(){
		String url = REQUEST_HTTP_URL + "/demoUser/insert";
		
		DemoUser user = new DemoUser();
		user.setCode("698533");
		user.setId(10000000);
		user.setDescription("测试数据");
		user.setComment("测试单元");
		user.setName("xyc");
		
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON_TYPE));
        try {
        	 Assert.assertEquals(200, response.getStatus());
		} finally{
			response.close();
			client.close();
		}
        
		//删除记录，可以重复执行单元测试
		url = REQUEST_HTTP_URL + "/demoUser/deleteByPrimaryKey/10000000";
		client = ClientBuilder.newClient();
		target = client.target(url);
		try{
			response = target.request().get();
			Assert.assertEquals(200, response.getStatus());
		}finally{
			response.close();
			client.close();
		}
        
	}
	
	@Test
	public void testSelectAll(){
		Result<List<DemoUser>> result = demoUserRestService.selectAll();
		Assert.assertEquals(17, result.getObj().size());
	}
}
