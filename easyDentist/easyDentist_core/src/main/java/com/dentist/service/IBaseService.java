package com.dentist.service;

import java.util.List;

import com.dentist.exception.FormException;
import com.dentist.utils.LayuiPage;
import com.dentist.utils.LayuiPageParam;

/**
 * 
 * mysite: http://www.xiudoua.com
 * @desc: 
 * @author: JustFresh
 * @date: 2018年5月25日 下午5:35:52 
 * @version: beta1.1
 */
public interface IBaseService<T> {

	/**
	 * 增加方法
	 * @param param
	 * @return
	 * @throws FormException
	 */
	public int add(T model) throws FormException;
	
	/**
	 * 通过主键删除一条记录的方法
	 * @param param
	 * @return
	 * @throws FormException
	 */
	public int delete(T model) throws FormException;
	
	/**
	 * 修改一条数据的方法
	 * @param param
	 * @return
	 * @throws FormException
	 */
	public int update(T model) throws FormException;
	
	/**
	 * 通过主键查询数据详细的方法
	 * @param param
	 * @return
	 * @throws FormException
	 */
	public T detail(T model) throws FormException;
	
	/**
	 * 条件查询列表的方法
	 * @param param
	 * @return
	 * @throws FormException
	 */
	public List<T> getList(T model) throws FormException;
	
	/**
	 * 符合Layui的分页查询返回的方法
	 * @param model
	 * @param param
	 * @return
	 * @throws FormException
	 */
	public LayuiPage<T> page(T model,LayuiPageParam param) throws FormException;
	
}