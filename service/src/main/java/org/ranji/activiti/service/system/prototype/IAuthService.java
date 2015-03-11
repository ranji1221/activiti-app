package org.ranji.activiti.service.system.prototype;

import java.util.List;

import org.ranji.activiti.model.system.Role;

/**
 * 授权服务类
 * 项目名称：service
 * 类名称：IAuthService
 * 创建人：RanJi
 * 创建时间: 2015-3-11 上午10:14:50
 * 修改人：RanJi
 * 修改时间：2015-3-11 上午10:14:50
 * 修改备注：
 * @version jdk1.5+
 */
public interface IAuthService {
	public void assignRole(int userId,int roleId);
	public void cancelRole(int userId,int roleId);
	
	public void assignRoles(int userId,List<Integer> roleIds);
	public void cancelRoles(int userId, List<Integer> roleIds);
	
	public List<Role> findRoles(int userId);
}
