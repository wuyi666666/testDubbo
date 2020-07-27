package org.example.service;

import com.sf.framework.mock.annt.TestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.pagehelper.Page;
import com.sf.framework.domain.Result;
import org.example.model.DemoUser;
import org.example.model.DemoUserExample;

/**
 * DemoUserrestful服务接口
 *
 * @author 698533
*/
@Path("demoUser")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
@Api("DemoUser")
public interface DemoUserRestService {


	/**
	 * 按主键删除
	 * 
	 * @param id 
	 * 
	 * @return Result<Integer>
	 *
    */
    @GET
	@Path("deleteByPrimaryKey/{id}")
    @ApiOperation(value="通过主键删除User-User表信息")
    Result<Integer> deleteByPrimaryKey(@PathParam("id") @TestParam("id") Integer id);

	/**
	 * 新增
	 * 
	 * @param record 记录
	 * 
	 * @return Result<Integer>
	 *
    */
	@POST
	@Path("insert")
	@ApiOperation(value="往User-User表新增信息")
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
	@POST
	@Path("selectByExample/{pageNum}/{pageSize}")
	@ApiOperation(value="通过条件分页查询User-User表信息")
	Result<Page<DemoUser>> selectByExample(@TestParam("example") DemoUserExample example, @PathParam("pageNum") @TestParam("pageNum") Integer pageNum, @PathParam("pageSize") @TestParam("pageSize") Integer pageSize);

	/**
	 * 按主键查询
	 * 
	 * @param id 
	 * 
	 * @return Result<DemoUser>
	 *
    */	
    @GET
	@Path("selectByPrimaryKey/{id}")
    @ApiOperation(value="通过主键获取User-User表信息")
    Result<DemoUser> selectByPrimaryKey(@PathParam("id") @TestParam("id") Integer id);
	
	/**
	 * 按主键更新,null的字段不更新
	 * 
	 * @param record 记录
	 * @return Result<Integer>
	 *
    */
	@POST
	@Path("updateByPrimaryKeySelective")
	@ApiOperation(value="更新User-User表信息，NUll字段不更新")
    Result<Integer> updateByPrimaryKeySelective(@TestParam("record") DemoUser record);

	/**
	 * 按主键更新
	 * 
	 * @param record 记录
	 * @return Result<Integer>
	 *
    */
	@POST
	@Path("updateByPrimaryKey")
	@ApiOperation(value="更新User-User表信息")
	Result<Integer> updateByPrimaryKey(@TestParam("record") DemoUser record);
	
	/**
	 * 非Leech生成代码，自己新增接口
	 * @return
	 */
	@GET
	@Path("selectAll")
	@ApiOperation(value="关联表查询")
	Result<List<DemoUser>> selectAll();
}