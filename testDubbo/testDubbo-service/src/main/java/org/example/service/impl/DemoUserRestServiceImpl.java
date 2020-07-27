package org.example.service.impl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sf.framework.domain.Result;
import com.sf.framework.utils.ConvertDomainUtils;
import com.sf.framework.validate.ParamValidate;
import org.example.manager.DemoUserManager;
import org.example.model.DemoUser;
import org.example.model.DemoUserExample;
import org.example.model.extend.DemoUserExtend;
import org.example.service.DemoUserRestService;

/**
 * DemoUserrestful服务实现类
 *
 * @author 698533
*/
@Service
public class DemoUserRestServiceImpl implements DemoUserRestService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Value("#{configProperties['system.name']}")
	//@Value("#{'system.name'}")
	private String sysName;
			
	@Autowired
	DemoUserManager demoUserManager;
	

	/**
	 * 按主键删除
	 * 
	 * @param id 
	 * 
	 * @return Result<Integer>
	 *
    */
	public Result<Integer> deleteByPrimaryKey(Integer id){
	    Result<Integer> result = new Result<Integer>(true); 
    	if(id == null){
    		throw new IllegalStateException("参数id不能为空");
    	}
		int count = 0;
		try{
			count = demoUserManager.deleteByPrimaryKey(id);
			result.setObj(Integer.valueOf(count));
		}
		catch(Exception e){
			result.setSuccess(false);
			result.setObj(Integer.valueOf(count));
			result.setErrorMessage("deleteByPrimaryKey error");
			logger.error("deleteByPrimaryKey error", e);
		}
		return result;
	}

	/**
	 * 新增
	 * 
	 * @param record 记录
	 * 
	 * @return Result<Integer>
	 *
    */
	@ParamValidate
	public Result<Integer> insert(DemoUser record){
	    Result<Integer> result = new Result<Integer>(true); 
		if(record == null){
			throw new IllegalStateException("参数record不能为空");
		}
    	if(record.getId() == null){
    		throw new IllegalStateException("主键id属性不能为空");
    	}
		int count = 0;
		try{
			count = demoUserManager.insert(record);
			result.setObj(Integer.valueOf(count));
		}
		catch(Exception e){
			result.setSuccess(false);
			result.setObj(Integer.valueOf(count));
			result.setErrorMessage("insert error");
			logger.error("insert error", e);
		}
		return result;
	}
	
	/**
	 * 按条件查询
	 * 
	 * @param example 条件
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * 
	 * @return  Page 
	 *
    */
	public Result<Page<DemoUser>> selectByExample(DemoUserExample example, Integer pageNum, Integer pageSize){
	    Result<Page<DemoUser>> result = new Result<Page<DemoUser>>(true);
		if(pageNum != null && pageNum < 1){
			throw new IllegalStateException("参数pageNum不能小于1");
		}
		if(pageSize != null && pageSize < 1){
			throw new IllegalStateException("参数pageSize不能小于1");
		}
		if((pageNum == null && pageSize != null)
			||(pageNum != null && pageSize == null)){
			throw new IllegalStateException("pageNum、pageSize必须同时为null或不为null");
		}
		if(pageNum == null && pageSize == null){//一次查所有数据
			pageNum = 1;
			pageSize = 0;
		}
		Page<DemoUser> records = new Page<DemoUser>();
		PageHelper.startPage(pageNum, pageSize);
		try{
			records = (Page<DemoUser>)demoUserManager.selectByExample(example);
			result.setObj(records);
		}
		catch(Exception e){
			result.setSuccess(false);
			result.setObj(records);
			result.setErrorMessage("selectByExample error");
			logger.error("selectByExample error", e);
		}
		return result;
	}

	/**
	 * 按主键查询
	 * 
	 * @param id 
	 * 
	 * @return  List 
	 *
    */
    public Result<DemoUser> selectByPrimaryKey(Integer id){
	    Result<DemoUser> result = new Result<DemoUser>(true);
    	if(id == null){
    		throw new IllegalStateException("参数id不能为空");
    	}
		DemoUser record = null;
		try{
			record = demoUserManager.selectByPrimaryKey(id);
			result.setObj(record);
		}
		catch(Exception e){
			result.setSuccess(false);
			result.setErrorMessage("selectByPrimaryKey error");
			logger.error("selectByPrimaryKey error", e);
		}
		return result;
	}

	/**
	 * 按主键更新,null的字段不更新
	 * 
	 * @param record 记录
	 * @return  List 
	 *
    */
    public Result<Integer> updateByPrimaryKeySelective(DemoUser record){
	    Result<Integer> result = new Result<Integer>(true);
		if(record == null){
			throw new IllegalStateException("参数record不能为空");
		}
    	if(record.getId() == null){
    		throw new IllegalStateException("主键id属性不能为空");
    	}
		int count = 0;
		try{
			count = demoUserManager.updateByPrimaryKeySelective(record);
			result.setObj(Integer.valueOf(count));
		}
		catch(Exception e){
			result.setSuccess(false);
			result.setObj(Integer.valueOf(count));
			result.setErrorMessage("updateByPrimaryKeySelective error");
			logger.error("updateByPrimaryKeySelective error", e);
		}
		return result;
	}

	/**
	 * 按主键更新
	 * 
	 * @param record 记录
	 * @return Result<Integer>
	 *
    */
	public Result<Integer> updateByPrimaryKey(DemoUser record){
	    Result<Integer> result = new Result<Integer>(true);
		if(record == null){
			throw new IllegalStateException("参数record不能为空");
		}
    	if(record.getId() == null){
    		throw new IllegalStateException("主键id属性不能为空");
    	}
		int count = 0;
		try{
			count = demoUserManager.updateByPrimaryKey(record);
			result.setObj(Integer.valueOf(count));
		}
		catch(Exception e){
			result.setSuccess(false);
			result.setObj(Integer.valueOf(count));
			result.setErrorMessage("updateByPrimaryKey error");
			logger.error("updateByPrimaryKey error", e);
		}
		return result;
	}

	/**
	 * 自己新增代码
	 */
	@Override
	public Result<List<DemoUser>> selectAll() {
		Result<List<DemoUser>> result = new Result<List<DemoUser>>(true);
		
		List<DemoUserExtend> list = demoUserManager.selectAll();
		if(CollectionUtils.isNotEmpty(list)){
			List<DemoUser> rList = ConvertDomainUtils.convertList(list, DemoUser.class);
			result.setObj(rList);
		}else{
			result.setSuccess(false);
			//自己按照业务逻辑定义一套错误码以及描述
			result.setErrorCode("001");
			result.setErrorMessage("-------");
		}
		
		return result;
	}
	
}