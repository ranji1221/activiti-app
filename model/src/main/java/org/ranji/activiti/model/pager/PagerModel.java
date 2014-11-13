package org.ranji.activiti.model.pager;

import java.util.List;

/**
 * 分页Model类
 * @author RanJi
 * @since 2014-11-12
 * @version jdk7
 */
public class PagerModel<T> {
	private int total;
	private List<T> data;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
