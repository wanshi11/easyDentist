package com.dentist.service;

import java.util.List;

import com.dentist.exception.FormException;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

/**
 * @date: 
 * @version: beta1.1
 */
public interface IBaseService<T> {

	/**
	 * 增加方法
	 * @param param
	 * @return
	 * @throws FormException
	 */
	public int add(T model);
	
	/**
	 * 通过实体删除一条记录的方法
	 * @param param
	 * @return
	 */
	public int delete(T model);
	
	/**
	 * 通过主键删除一条记录的方法
	 * @param param
	 * @return
	 */
	public int deleteById(Integer id);
	
	/**
	 * 修改一条数据的方法
	 * @param param
	 * @return
	 */
	public int update(T model);
	
	/**
	 * 通过主键查询数据详细的方法
	 * @param param
	 * @return
	 */
	public T detail(T model);
	
	/**
	 * 条件查询列表的方法
	 * @param param
	 * @return
	 */
	public List<T> getList(T model);
	
	/**
	 * 符合Layui的分页查询返回的方法
	 * @param model
	 * @param param
	 * @return
	 */
	public LayuiPage<T> page(T model,LayuiPageParam param);
	
}