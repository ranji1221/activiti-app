package org.ranji.activiti.service.system.impl;

import java.util.List;

import org.ranji.activiti.model.system.Role;
import org.ranji.activiti.service.system.prototype.IAuthService;

public class AuthServiceImpl implements IAuthService{

	@Override
	public void assignRole(int userId, int roleId) {
		
	}

	@Override
	public void cancelRole(int userId, int roleId) {
		
	}

	@Override
	public void assignRoles(int userId, List<Integer> roleIds) {
		
	}

	@Override
	public void cancelRoles(int userId, List<Integer> roleIds) {
		
	}

	@Override
	public List<Role> findRoles(int userId) {
		return null;
	}

}
