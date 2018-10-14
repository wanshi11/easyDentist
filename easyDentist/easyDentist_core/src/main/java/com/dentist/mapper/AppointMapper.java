package com.dentist.mapper;

import com.dentist.entity.Appoint;
import com.dentist.entity.AppointExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AppointMapper {
    int countByExample(AppointExample example);

    int deleteByExample(AppointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Appoint record);

    int insertSelective(Appoint record);

    List<Appoint> selectByExample(AppointExample example);

    Appoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Appoint record, @Param("example") AppointExample example);

    int updateByExample(@Param("record") Appoint record, @Param("example") AppointExample example);

    int updateByPrimaryKeySelective(Appoint record);

    int updateByPrimaryKey(Appoint record);

    List<Appoint> selectWithPageByExample(@Param("example") AppointExample example,
			@Param("params") Map<String, String> params);
}