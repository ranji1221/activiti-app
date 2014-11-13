package org.ranji.activiti.persist.system.impl;

import org.ranji.activiti.model.system.User;
import org.ranji.activiti.persist.common.impl.GenericDaoImpl;
import org.ranji.activiti.persist.system.prototype.IUserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements IUserDao{}
