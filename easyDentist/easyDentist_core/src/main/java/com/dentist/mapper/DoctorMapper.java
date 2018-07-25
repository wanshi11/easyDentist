package com.dentist.mapper;

import com.dentist.entity.Doctor;
import com.dentist.entity.DoctorExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

	List<Doctor> selectWithPageByExample(@Param("example")DoctorExample doctorExample,@Param("params") Map<String, String> params);
}