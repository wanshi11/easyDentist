package com.dentist.service;

import java.util.List;

import com.dentist.entity.Banner;
import com.dentist.utils.LayuiPageParam;

public interface BannerService extends IBaseService<Banner> {
	
	
	//����������ѯ��ҳ����
    List<Banner> selectWithPageByExample(Banner banner,LayuiPageParam param);
    
    
  //����������ѯ����������
  	int selectCountByExample(Banner banner);

}
