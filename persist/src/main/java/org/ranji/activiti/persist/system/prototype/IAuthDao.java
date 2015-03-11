package org.ranji.activiti.persist.system.prototype;

import java.util.List;
import org.ranji.activiti.model.system.Role;
/**
 * 
 * 项目名称：persist
 * 类名称：IAuthDao
 * 创建人：RanJi
 * 创建时间: 2015-3-11 上午10:41:56
 * 修改人：RanJi
 * 修改时间：2015-3-11 上午10:41:56
 * 修改备注：
 * @version jdk1.5+
 */
public interface IAuthDao {
	public void assignRole(int userId,int roleId);
	public void cancelRole(int userId,int roleId);
	
	public void assignRoles(int userId,List<Integer> roleIds);
	public void cancelAllRoles(int userId);
	
	public List<Role> findRoles(int userId);
}
