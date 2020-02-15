package com.dentist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Policlinic;
import com.dentist.mapper.PoliclinicMapper;
import com.dentist.service.PoliclinicService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;
import com.dentist.utils.Page;

@Transactional
@Service
public class PoliclinicServiceImpl implements PoliclinicService {
	
	@Autowired
	private PoliclinicMapper policlinicMapper;

	@Override
	public int add(Policlinic model) {
		// TODO Auto-generated method stub
		return policlinicMapper.insert(model);
	}

	@Override
	public int delete(Policlinic model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Policlinic model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Policlinic detail(Policlinic model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Policlinic> getList(Policlinic model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Policlinic> page(Policlinic model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Policlinic> selectWithPageByExample(Policlinic polic,
			LayuiPageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCountByExample(Policlinic polic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Policlinic queryPoliclinicById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Policlinic> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Policlinic> queryDoctorsByPoliclinicName(String policlinicName,
			Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

}
