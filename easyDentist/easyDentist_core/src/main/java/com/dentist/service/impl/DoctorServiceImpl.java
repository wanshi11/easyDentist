package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dentist.entity.Doctor;
import com.dentist.entity.DoctorExample;
import com.dentist.mapper.DoctorMapper;
import com.dentist.service.DoctorService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;
import com.dentist.utils.Page;

@Transactional
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorMapper doctorMapper;

	@Override
	public int add(Doctor model) {
		// TODO Auto-generated method stub
		return doctorMapper.insertSelective(model);
	}


	@Override
	public int update(Doctor model) {
		// TODO Auto-generated method stub
		return doctorMapper.updateByPrimaryKeySelective(model);
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
		LayuiPage<Doctor> layui = new LayuiPage<>();
		layui.setCount(selectCountByExample(model));
		layui.setData(selectWithPageByExample(model, param));
		return layui;
	}

	@Override
	public List<Doctor> selectWithPageByExample(Doctor doctor,
			LayuiPageParam param) {
		
		DoctorExample doctorExample = new DoctorExample();
		DoctorExample.Criteria c = doctorExample.createCriteria();
		if(null != doctor && !StringUtils.isEmpty(doctor.getDoctorname())){
			c.andDoctornameLike('%'+doctor.getDoctorname()+'%');
		}
		Map<String, String> params = new HashMap<>();
		params.put("order", param.getOrder());
		params.put("sort", param.getSort());	
		params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
		params.put("pageSize", param.getLimit()+"");	
		
		
		
		return doctorMapper.selectWithPageByExample(doctorExample, params);
	}

	@Override
	public int selectCountByExample(Doctor doctor) {
		// TODO Auto-generated method stub
		DoctorExample doctorExample = new DoctorExample();
		DoctorExample.Criteria c = doctorExample.createCriteria();
		if(null != doctor && !StringUtils.isEmpty(doctor.getDoctorname())){
			c.andDoctornameLike('%'+doctor.getDoctorname()+'%');
		}
		
		return doctorMapper.countByExample(doctorExample);
	}

	@Override
	public Doctor queryDoctorById(int id) {

		return doctorMapper.selectByPrimaryKey(id);
	}


	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return doctorMapper.deleteByPrimaryKey(id);
	}


	@Override
	public int delete(Doctor model) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Doctor> getAllList() {
		// TODO Auto-generated method stub
		DoctorExample doctorExample = new DoctorExample();
		DoctorExample.Criteria c = doctorExample.createCriteria();
	    c.andPicpathIsNotNull();
	    c.andInchphotopathIsNotNull();
		
		return doctorMapper.selectByExample(doctorExample);
	}


	@Override
	public Page<Doctor> queryDoctorsByDortorNameAndClinic(String doctorname,
			String clinic, Integer page) {
		// TODO Auto-generated method stub
		 Page<Doctor> pager = new Page<>();

			if(page == null){
				page = 1;
			}
			
			int total = doctorMapper.queryDoctorsPageCountByDoctorNameAndClinic(doctorname,clinic);
			pager.setTotalRecord(total);
			
			List<Doctor> list = doctorMapper.queryDoctorsPageInfoByDoctorNameAndClinic((page-1)*pager.getPageSize(), pager.getPageSize(),doctorname,clinic);
			pager.setList(list);
			pager.setCurrentPage(page);
			
			
			return pager;
	}

}
