package org.ranji.activiti.service.system.impl;


import org.ranji.activiti.model.system.User;
import org.ranji.activiti.service.common.impl.GenericServiceImpl;
import org.ranji.activiti.service.system.prototype.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements
		IUserService {
	
}
