package org.ranji.activiti.persist.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.ranji.activiti.model.system.Role;
import org.ranji.activiti.persist.system.prototype.IAuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 分配角色，认证，授权的dao操作类
 * 项目名称：persist
 * 类名称：AuthDaoImpl
 * 创建人：RanJi
 * 创建时间: 2015-3-11 上午10:44:41
 * 修改人：RanJi
 * 修改时间：2015-3-11 上午10:44:41
 * 修改备注：
 * @version jdk1.5+
 */
@Repository
public class AuthDaoImpl implements IAuthDao{
	
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void assignRole(int userId, int roleId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId", userId);
		map.put("roleId", roleId);
		sqlSessionTemplate.insert("org.ranji.activiti.model.system.Auth.assignRole", map);
	}

	@Override
	public void cancelRole(int userId, int roleId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId", userId);
		map.put("roleId", roleId);
		sqlSessionTemplate.delete("org.ranji.activiti.model.system.Auth.cancelRole", map);
	}

	@Override
	public void assignRoles(int userId, List<Integer> roleIds) {
		cancelAllRoles(userId);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("roleIds", roleIds);
		sqlSessionTemplate.insert("org.ranji.activiti.model.system.Auth.assignRoles", map);
	}

	@Override
	public List<Role> findRoles(int userId) {
		return sqlSessionTemplate.selectList("org.ranji.activiti.model.system.Auth.findRoles",userId);
	}
	
	//-- 取消某用户所关联的所有角色
	@Override
	public void cancelAllRoles(int userId) {
		sqlSessionTemplate.delete("org.ranji.activiti.model.system.Auth.cancelAllRoles",userId);
	}

}
