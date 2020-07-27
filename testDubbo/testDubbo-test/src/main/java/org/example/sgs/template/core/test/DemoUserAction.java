package org.example.sgs.template.core.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sf.framework.domain.Result;
import org.example.model.DemoUser;
import org.example.service.DemoUserRestService;
import org.example.service.DemoUserService;

public class DemoUserAction {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private DemoUserService demoUserService;
	
	private DemoUserRestService demoUserRestService;


	public void setDemoUserService(DemoUserService demoUserService) {
		this.demoUserService = demoUserService;
	}


	public void setDemoUserRestService(DemoUserRestService demoUserRestService) {
		this.demoUserRestService = demoUserRestService;
	}


	public void start() throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            try {
            	Result<DemoUser> result = demoUserService.selectByPrimaryKey(1);
            	if(result.getObj()!=null) {
					System.out.println(result.getObj().getName());
				}
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
        }
	}
	
}
