package org.ranji.activiti.persist.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.activiti.model.system.User;
import org.ranji.activiti.persist.system.prototype.IUserDao;
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
public class UserDaoTest {
	
	@Autowired
	private IUserDao userDao;
	
	@Before
	public void init(){}
	
	@Test
	public void testAddUser(){
		User u = new User("zhangsan", "456", -1, "测试用户");
		userDao.save(u);
		System.out.println(u.getId());
	}
	
	@Test
	public void testDeleteUser(){
		userDao.delete(9);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userName", "zhangsan");
		userDao.deleteAll(params);
	}
	
	@Test
	public void testFindUser(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userName", "zhangsan");
		params.put("enabled", -1);
		List<User> users = userDao.findAll(params);
		System.out.println(users.size());
		
		users = userDao.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindPaginatedUser(){
		
	}
}
