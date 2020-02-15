package com.dentist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dentist.entity.Doctor;
import com.dentist.entity.DoctorExample;

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

	int queryDoctorsPageCountByDoctorNameAndClinic(@Param("doctorname") String doctorname,
			@Param("clinic") String clinic);

	List<Doctor> queryDoctorsPageInfoByDoctorNameAndClinic(@Param(value="start") Integer start, @Param(value="size") Integer size,
			@Param("doctorname") String doctorname,@Param("clinic") String clinic);

}