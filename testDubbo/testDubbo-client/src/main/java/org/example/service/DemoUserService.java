package org.example.service;

import com.github.pagehelper.Page;
import com.sf.framework.domain.Result;
import com.sf.framework.mock.annt.TestParam;
import org.example.model.DemoUser;
import org.example.model.DemoUserExample;

/**
 * DemoUserService类
 *
 * @author 698533
*/
public interface DemoUserService {
	

	/**
	 * 按主键删除
	 * 
	 * @param id 
	 * 
	 * @return Result<Integer>
	 *
    */
	Result<Integer> deleteByPrimaryKey(@TestParam("id") Integer id);

	/**
	 * 新增
	 * 
	 * @param record 记录
	 * 
	 * @return Result<Integer>
	 *
    */
	Result<Integer> insert(@TestParam("record") DemoUser record);
	
	/**
	 * 按条件查询
	 * 
	 * @param example 条件
	 * @param pageNum 页码
	 * @param pageSize 每页数量
	 * 
	 * @return Result<Page<DemoUser>>
	 *
    */
	Result<Page<DemoUser>> selectByExample(@TestParam("example") DemoUserExample example, @TestParam("pageNum") Integer pageNum, @TestParam("pageSize") Integer pageSize);

	/**
	 * 按主键查询
	 * 
	 * @param id 
	 * 
	 * @return Result<DemoUser>
	 *
    */
    Result<DemoUser> selectByPrimaryKey(@TestParam("id") Integer id);

	/**
	 * 按主键更新,null的字段不更新
	 * 
	 * @param record 记录
	 * @return Result<Integer>
	 *
    */
    Result<Integer> updateByPrimaryKeySelective(@TestParam("record") DemoUser record);

	/**
	 * 按主键更新
	 * 
	 * @param record 记录
	 * @return Result<Integer>
	 *
    */
	Result<Integer> updateByPrimaryKey(@TestParam("record") DemoUser record);
	
}