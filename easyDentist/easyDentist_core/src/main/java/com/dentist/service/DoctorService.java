package com.dentist.service;

import java.util.List;

import com.dentist.entity.Doctor;
import com.dentist.utils.LayuiPageParam;


public interface DoctorService extends IBaseService<Doctor> {

	    //根据条件查询分页数据
		List<Doctor> selectWithPageByExample(Doctor doctor,LayuiPageParam param);
		
		//根据条件查询总数据条数
		int selectCountByExample(Doctor doctor);

}
