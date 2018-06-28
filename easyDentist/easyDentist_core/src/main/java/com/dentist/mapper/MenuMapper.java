package com.dentist.mapper;

import com.dentist.entity.Menu;
import com.dentist.entity.MenuExample;
import com.dentist.entity.Role;
import com.dentist.entity.RoleExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> selectWithPageByExample(@Param("example")MenuExample menuExample,
			@Param("params")Map<String, String> params);
}