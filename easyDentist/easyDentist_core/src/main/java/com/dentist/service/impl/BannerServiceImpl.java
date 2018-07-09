package com.dentist.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Banner;
import com.dentist.service.BannerService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("bannerService")
public class BannerServiceImpl implements BannerService {

	@Override
	public int add(Banner model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Banner model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Banner model) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Banner detail(Banner model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banner> getList(Banner model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Banner> page(Banner model, LayuiPageParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}
