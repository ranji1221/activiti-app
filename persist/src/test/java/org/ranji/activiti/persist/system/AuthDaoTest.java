package org.ranji.activiti.persist.system;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.activiti.model.system.Role;
import org.ranji.activiti.persist.system.prototype.IAuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserDao测试类
 * @author RanJi
 * @since 2014-11-12
 * @version jdk7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-persist.xml")
public class AuthDaoTest {
	
	@Autowired
	private IAuthDao authDao;
	
	@Before
	public void init(){}
	
	@Test
	public void testAssignRole(){
		authDao.assignRole(1, 2);
	}
	
	@Test
	public void testCancelRole(){
		authDao.cancelRole(1, 2);
	}
	
	@Test
	public void testAssignRoles(){
		authDao.assignRoles(1, Arrays.asList(new Integer[]{2,3}));
	}
	
	@Test
	public void testCancelAllRoles(){
		authDao.cancelAllRoles(1);
	}
	
	@Test
	public void testFindRoles(){
		for (Role role : authDao.findRoles(1)) {
			System.out.println(role.getId()+":"+role.getName()+":"+role.getDescription());
		}
	}
	

}
