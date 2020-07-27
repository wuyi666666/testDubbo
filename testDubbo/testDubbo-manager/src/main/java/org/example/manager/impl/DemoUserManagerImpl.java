package org.example.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.example.manager.DemoUserManager;
import org.example.mapper.DemoUserMapper;
import org.example.model.DemoUser;
import org.example.model.DemoUserExample;
import org.example.model.extend.DemoUserExtend;

/**
 * DemoUserManager实现类
 *
 * @author 698533
*/
@Component
public class DemoUserManagerImpl implements DemoUserManager {

	@Autowired
	private DemoUserMapper demoUserMapper;
	

	
	/**
	 * 按主键删除
	 * 
	 * @param id 
	 * 
	 * @return int 成功条数  
	 *
    */
	@Override
    public int deleteByPrimaryKey(Integer id){
		return demoUserMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 新增
	 * 
	 * @param record 记录
	 * 
	 * @return int 成功条数  
	 *
    */
	@Override
    public int insert(DemoUser record){
	    return demoUserMapper.insert(record);
	}
	
	/**
	 * 新增,null字段不插入
	 * 
	 * @param record 记录
	 * 
	 * @return int 成功条数  
	 *
    */
	@Override
    public int insertSelective(DemoUser record){
		return demoUserMapper.insertSelective(record);
	}
	
	
	/**
	 * 按条件查询
	 * 
	 * @param example 条件
	 * 
	 * @return List<DemoUser> 记录列表
	 *
    */
	@Override
    public List<DemoUser> selectByExample(DemoUserExample example){
		return demoUserMapper.selectByExample(example);
	}

	/**
	 * 按主键查询
	 * 
	 * @param id 
	 * 
	 * @return DemoUser 记录 
	 *
    */
	@Override
    public DemoUser selectByPrimaryKey(Integer id){
		return demoUserMapper.selectByPrimaryKey(id);
	}


	

	/**
	 * 按主键更新,null的字段不更新
	 * 
	 * @param record 记录
	 * @return int 成功条数 
	 *
    */
    public int updateByPrimaryKeySelective(DemoUser record){
		return demoUserMapper.updateByPrimaryKeySelective(record);
	}


	/**
	 * 按主键更新
	 * 
	 * @param record 记录
	 * @return int 成功条数 
	 *
    */
	@Override
    public int updateByPrimaryKey(DemoUser record){
		return demoUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DemoUserExtend> selectAll() {
		return demoUserMapper.selectAll();
	}
	
}