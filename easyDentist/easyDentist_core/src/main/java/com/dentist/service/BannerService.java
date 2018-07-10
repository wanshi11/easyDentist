package com.dentist.service;

import java.util.List;

import com.dentist.entity.Banner;
import com.dentist.utils.LayuiPageParam;

public interface BannerService extends IBaseService<Banner> {
	
	
	//根据条件查询分页数据
    List<Banner> selectWithPageByExample(Banner banner,LayuiPageParam param);
    
    
  //根据条件查询总数据条数
  	int selectCountByExample(Banner banner);

}
