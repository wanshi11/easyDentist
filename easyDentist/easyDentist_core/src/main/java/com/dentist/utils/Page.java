package com.dentist.utils;
import java.util.List;


public class Page<T> {
	
	private final static int PAGEITEMCOUNT = 10; // 显示页码条目数，即页码数量顶多是10个
	private List<T> list; // 保存查询的结果集合
	private int totalRecord; // 总记录数
	private int pageSize = 5; // 页面显示的数目
	private Integer totalPage; // 总页码数
	private int currentPage = 1; // 当前页码
	private int previousPage; // 前一页
	private int nextPage; // 后一页
	private int[] pageBar; // 条目数
	private int startIndex; // 开始页
	private int endIndex; // 结束页

	public int getStartIndex() {
		this.startIndex = this.currentPage - 2 > 0 ? this.currentPage - 2 : 1;
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		int end = this.currentPage + 2 > this.getTotalPage() ? this.getTotalPage() : this.currentPage + 2;
		this.endIndex = end;
		return this.endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setTotalPage(int totalPage){
		this.totalPage = totalPage;
	}

	public Integer getTotalPage() { // 得到总页码数
		if (this.totalRecord % this.pageSize == 0) {
			this.totalPage = this.totalRecord / this.pageSize;
		} else {
			this.totalPage = this.totalRecord / this.pageSize + 1;
		}
		return totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		if (this.currentPage - 1 < 1) { // 如果上一页小于1，则说明当前页码已经是第一页了
			this.previousPage = 1;
		} else {
			this.previousPage = this.currentPage - 1;
		}
		return previousPage;
	}

	public int getNextPage() {
		if (this.currentPage + 1 >= this.totalPage) { // 如果下一页大于总数页，则说明当前页码已经是最后一页了
			this.nextPage = this.totalPage;
		} else {
			this.nextPage = this.currentPage + 1;
		}
		return nextPage;
	}

	public int[] getPageBar() {
		int startPage; // 记住页码的起始位置
		int endPage; // 记住页码的结束位置，因为页码条目是既定的，由startpage，endpage两个变量通过循环就可以得全部页码
		int pageBar[] = null;
		if (this.getTotalPage() <= PAGEITEMCOUNT) { // 当总页码不足或等于既定页面大小时
			pageBar = new int[this.totalPage];
			startPage = 1;
			endPage = this.totalPage;
		} else { // 当总页码大于既定页面大小时
			pageBar = new int[PAGEITEMCOUNT];
			startPage = this.currentPage - (PAGEITEMCOUNT / 2 - 1); // 为了保证当前页在中间
			endPage = this.currentPage + PAGEITEMCOUNT / 2;

			if (startPage < 1) {
				startPage = 1;
				endPage = PAGEITEMCOUNT;
			}

			if (endPage > this.totalPage) {
				endPage = this.totalPage;
				startPage = this.totalPage - (PAGEITEMCOUNT - 1);
			}
		}

		int index = 0;
		for (int i = startPage; i <= endPage; i++) {
			pageBar[index++] = i;
		}

		this.pageBar = pageBar;
		return this.pageBar;
	}
}