package com.dentist.service;

import java.util.List;

import com.dentist.entity.Appoint;
import com.dentist.utils.LayuiPageParam;

public interface AppointService extends IBaseService<Appoint> {
	
	
	
	
	//根据ID名
	Appoint queryAppointById(Integer id);
	
	//根据条件查询分页数据
	List<Appoint> selectWithPageByExample(Appoint appoint,LayuiPageParam param);
	
	//根据条件查询总数据条数
	int selectCountByExample(Appoint appoint);
	

}