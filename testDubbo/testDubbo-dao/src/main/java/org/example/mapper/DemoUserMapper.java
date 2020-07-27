package org.example.mapper;

import org.example.model.DemoUser;
import org.example.model.DemoUserExample;
import org.example.model.extend.DemoUserExtend;

import java.util.List;

/**
 * 
 * @author 698533
 */
public interface DemoUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DemoUser record);

    int insertSelective(DemoUser record);

    List<DemoUser> selectByExample(DemoUserExample example);

    DemoUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DemoUser record);

    int updateByPrimaryKey(DemoUser record);
    
    /**
	 * 自定义方法，查询关联信息
	 * @return
	 */
	List<DemoUserExtend> selectAll();
}