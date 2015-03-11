package org.ranji.activiti.model.system;

import java.io.Serializable;

/**
 * 项目名称：model
 * 类名称：Role
 * 创建人：RanJi
 * 创建时间: 2015-3-11 上午9:11:48
 * 修改人：RanJi
 * 修改时间：2015-3-11 上午9:11:48
 * 修改备注：
 * @version jdk1.5+
 */
public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String description;
	
	public Role() {}
	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
