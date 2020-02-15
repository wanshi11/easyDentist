package com.dentist.service;

import java.util.List;

import com.dentist.entity.Doctor;
import com.dentist.utils.LayuiPageParam;
import com.dentist.utils.Page;


public interface DoctorService extends IBaseService<Doctor> {

		List<Doctor> selectWithPageByExample(Doctor doctor,LayuiPageParam param);
		
		int selectCountByExample(Doctor doctor);

		Doctor queryDoctorById(int id);
		
		List<Doctor> getAllList();

		Page<Doctor> queryDoctorsByDortorNameAndClinic(String doctorname,
				String clinic, Integer page);

}
