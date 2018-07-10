package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentist.entity.Banner;
import com.dentist.entity.BannerExample;
import com.dentist.mapper.BannerMapper;
import com.dentist.service.BannerService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("bannerService")
public class BannerServiceImpl implements BannerService {
	
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public int add(Banner model) {
		// TODO Auto-generated method stub
		return bannerMapper.insertSelective(model);
	}

	@Override
	public int delete(Banner model) {
		// TODO Auto-generated method stub
		return bannerMapper.deleteByPrimaryKey(model.getId());
	}

	@Override
	public int update(Banner model) {
		// TODO Auto-generated method stub
		return bannerMapper.updateByPrimaryKeySelective(model);
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
		LayuiPage<Banner> page = new LayuiPage<>();
		page.setCount(selectCountByExample(model));
		page.setData(selectWithPageByExample(model, param));
		return page;
	}

	@Override
	public List<Banner> selectWithPageByExample(Banner banner,
			LayuiPageParam param) {
		// TODO Auto-generated method stub
		BannerExample bannerExample = new BannerExample();
		
		Map<String, String> params = new HashMap<>();
		params.put("order", param.getOrder());
		params.put("sort", param.getSort());	
		params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
		params.put("pageSize", param.getLimit()+"");	
		
		return bannerMapper.selectWithPageByExample(bannerExample, params);
	}

	@Override
	public int selectCountByExample(Banner banner) {
		// TODO Auto-generated method stub
		return bannerMapper.countByExample(null);
	}

	@Override
	public Banner queryBannerById(int id) {
		// TODO Auto-generated method stub
		return bannerMapper.selectByPrimaryKey(id);
	}

}
