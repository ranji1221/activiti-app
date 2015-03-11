package org.ranji.activiti.persist.system.impl;

import org.ranji.activiti.model.system.Role;
import org.ranji.activiti.persist.common.impl.GenericDaoImpl;
import org.ranji.activiti.persist.system.prototype.IRoleDao;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements IRoleDao {
	
}
