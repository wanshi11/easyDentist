package com.dentist.service;

import java.util.List;

import com.dentist.entity.Banner;
import com.dentist.utils.LayuiPageParam;

public interface BannerService extends IBaseService<Banner> {
	
	
	//根据分页条件查询记录
    List<Banner> selectWithPageByExample(Banner banner,LayuiPageParam param);
    
    
    //查询记录数
  	int selectCountByExample(Banner banner);


	Banner queryBannerById(int id);

	
	List<Banner> queryBannerByType(String bannerType);
	
	int insertAndGetId(Banner banner);

}
