package org.example.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.Page;
import com.sf.framework.domain.Result;
import org.example.model.DemoUser;
import org.example.model.DemoUserExample;
import org.example.service.DemoUserRestService;

public class DemoUserRestServiceImpl2 implements DemoUserRestService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Result<Integer> deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> insert(DemoUser record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Page<DemoUser>> selectByExample(DemoUserExample example,
			Integer pageNum, Integer pageSize) {
		HttpServletRequest httpRequest = ResteasyProviderFactory.getContextData(HttpServletRequest.class);
        UriInfo uriInfo = ResteasyProviderFactory.getContextData(UriInfo.class);
        HttpHeaders httpHeaders = ResteasyProviderFactory.getContextData(HttpHeaders.class);
        logger.info("httpRequest={}, uriInfo={}, httpHeaders={}", httpRequest, uriInfo, httpHeaders);
        return null;
	}

	@Override
	public Result<DemoUser> selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> updateByPrimaryKeySelective(DemoUser record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> updateByPrimaryKey(DemoUser record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<List<DemoUser>> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
