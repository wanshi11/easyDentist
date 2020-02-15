package com.dentist.service;

import java.util.List;

import com.dentist.entity.Policlinic;
import com.dentist.utils.LayuiPageParam;
import com.dentist.utils.Page;


public interface PoliclinicService extends IBaseService<Policlinic> {

		List<Policlinic> selectWithPageByExample(Policlinic polic,LayuiPageParam param);
		
		int selectCountByExample(Policlinic polic);

		Policlinic queryPoliclinicById(int id);
		
		List<Policlinic> getAllList();

		Page<Policlinic> queryDoctorsByPoliclinicName(String policlinicName,
				 Integer page);

}
