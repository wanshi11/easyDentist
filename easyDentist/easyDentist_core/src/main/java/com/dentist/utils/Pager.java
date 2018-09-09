package com.dentist.utils;

import java.util.List;

/**
 * 分页对象
 *
 * @param <T>
 * @author Administrator
 */
public class Pager<T> {

    public static final Integer DEFAULT_PAGE_SIZE = 10;
    /**
     * 分页的大小 第几页
     */
    private Integer size;
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 分页的数据
     */
    private List<T> datas; 
    private Integer firstPage;  //首页
    private Integer endPage;  //末页 
    private Integer currentPage;//当前页
    
    
    
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	


    
}
