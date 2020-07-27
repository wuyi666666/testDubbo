package org.example.manager;

import java.util.List;

import org.example.model.DemoUser;
import org.example.model.DemoUserExample;
import org.example.model.extend.DemoUserExtend;

/**
 * DemoUserManager类
 *
 * @author 698533
*/
public interface DemoUserManager {
	

	
	/**
	 * 按主键删除
	 * 
	 * @param id 
	 * 
	 * @return int 成功条数  
	 *
    */
    int deleteByPrimaryKey(Integer id);

	/**
	 * 新增
	 * 
	 * @param record 记录
	 * 
	 * @return int 成功条数  
	 *
    */
    int insert(DemoUser record);
	
	/**
	 * 新增,null字段不插入
	 * 
	 * @param record 记录
	 * 
	 * @return int 成功条数  
	 *
    */
    int insertSelective(DemoUser record);
	
	
	/**
	 * 按条件查询
	 * 
	 * @param example 条件
	 * 
	 * @return List<DemoUser> 记录列表
	 *
    */
    List<DemoUser> selectByExample(DemoUserExample example);

	/**
	 * 按主键查询
	 * 
	 * @param id 
	 * 
	 * @return DemoUser 记录 
	 *
    */
    DemoUser selectByPrimaryKey(Integer id);


	

	/**
	 * 按主键更新,null的字段不更新
	 * 
	 * @param record 记录
	 * @return int 成功条数 
	 *
    */
    int updateByPrimaryKeySelective(DemoUser record);


	/**
	 * 按主键更新
	 * 
	 * @param record 记录
	 * @return int 成功条数 
	 *
    */
    int updateByPrimaryKey(DemoUser record);
    
    /**
     * 自己新增方法
     */
    List<DemoUserExtend> selectAll();
	
}