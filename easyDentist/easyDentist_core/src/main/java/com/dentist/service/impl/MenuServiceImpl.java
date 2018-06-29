package com.dentist.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.dentist.entity.Menu;
import com.dentist.entity.MenuExample;
import com.dentist.mapper.MenuMapper;
import com.dentist.service.MenuService;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

@Transactional
@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper mapper;

	@Override
	public int add(Menu model)  {
		// TODO Auto-generated method stub
		return mapper.insert(model);
	}

	@Override
	public int delete(Menu model)  {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(model.getId());
	}

	@Override
	public int update(Menu model)  {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(model);
	}

	@Override
	public Menu detail(Menu model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getList(Menu model)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LayuiPage<Menu> page(Menu model, LayuiPageParam param)
			 {
		LayuiPage<Menu> layui = new LayuiPage<>();
		layui.setCount(selectCountByExample(model));
		layui.setData(selectWithPageByExample(model, param));
		return layui;
	}

	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		List<Menu> list =  mapper.selectByExample(null);
		return list;
	}

	@Override
	public List<Menu> selectWithPageByExample(Menu menu, LayuiPageParam param) {
		
		MenuExample menuExample = new MenuExample();
		MenuExample.Criteria c = menuExample.createCriteria();
				if(null != menu && !StringUtils.isEmpty(menu.getMenuname())){
					c.andMenunameLike('%'+menu.getMenuname()+'%');
				}
				Map<String, String> params = new HashMap<>();
				params.put("order", param.getOrder());
				params.put("sort", param.getSort());	
				params.put("rowStart", (param.getPage()-1)*param.getLimit()+"");	
				params.put("pageSize", param.getLimit()+"");	
				
				
				
				return mapper.selectWithPageByExample(menuExample, params);
	}

	@Override
	public int selectCountByExample(Menu menu) {
		// TODO Auto-generated method stub
		MenuExample menuExample = new MenuExample();
		MenuExample.Criteria c = menuExample.createCriteria();
		if(null != menu && !StringUtils.isEmpty(menu.getMenuname())){
			c.andMenunameLike('%'+menu.getMenuname()+'%');
		}
		
		return  mapper.countByExample(menuExample);
	}

	@Override
	public List<Menu> getAllParentMenus() {
		// TODO Auto-generated method stub
		MenuExample menuExample = new MenuExample();
		MenuExample.Criteria c = menuExample.createCriteria();
	     c.andParentidIsNull();
		
		return mapper.selectByExample(menuExample);
	}

	@Override
	public Menu checkMenuName(String menuname) {
		// TODO Auto-generated method stub
		MenuExample menuExample = new MenuExample();
		MenuExample.Criteria c = menuExample.createCriteria();
//	     if(!StringUtils.isEmpty(menuname)){
	    	 c.andMenunameEqualTo(menuname);
//	     }
		List<Menu> list =  mapper.selectByExample(menuExample);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
		
	}

	@Override
	public Menu checkUrl(String url) {
		MenuExample menuExample = new MenuExample();
		MenuExample.Criteria c = menuExample.createCriteria();
//	     if(!StringUtils.isEmpty(url)){
	    	 c.andUrlEqualTo(url);
//	     }
		List<Menu> list =  mapper.selectByExample(menuExample);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Menu queryMenuById(Integer id) {
		
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Menu queryMenuNotRepeatByMenuName(String menuname, Integer id) {
		
		MenuExample menuExample = new MenuExample();
		MenuExample.Criteria c = menuExample.createCriteria();
	     if(!StringUtils.isEmpty(menuname)){
	    	 c.andMenunameEqualTo(menuname);
	     }
	     c.andIdNotEqualTo(id);
		List<Menu> list =  mapper.selectByExample(menuExample);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Menu queryMenuNotRepeatByMenuUrl(String url, Integer id) {
		
		MenuExample menuExample = new MenuExample();
		MenuExample.Criteria c = menuExample.createCriteria();
	     if(!StringUtils.isEmpty(url)){
	    	 c.andUrlEqualTo(url);
	     }
	     c.andIdNotEqualTo(id);
		List<Menu> list =  mapper.selectByExample(menuExample);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
	
	
	

}
