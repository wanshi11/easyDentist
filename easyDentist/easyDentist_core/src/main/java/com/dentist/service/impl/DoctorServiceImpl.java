package com.dentist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Doctor;
import com.dentist.service.DoctorService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Override
	public int add(Doctor model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Doctor model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Doctor model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Doctor detail(Doctor model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getList(Doctor model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Doctor> page(Doctor model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}
