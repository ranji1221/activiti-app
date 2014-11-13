package org.ranji.activiti.model.system;

import java.io.Serializable;
/**
 * User实体类
 * @author RanJi
 * @since 2014-11-12
 * @version jdk7
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userName;
	private String pwd;

	private int enabled;
	private String description;
	
	public User() {}
	public User(String userName, String pwd, int enabled,
			String description) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.enabled = enabled;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "{"+userName+":"+enabled+":"+description+"}";
	}
}
