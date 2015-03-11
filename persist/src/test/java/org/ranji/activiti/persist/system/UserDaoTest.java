package org.ranji.activiti.persist.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.activiti.model.pager.PagerModel;
import org.ranji.activiti.model.system.User;
import org.ranji.activiti.persist.system.prototype.IUserDao;
import org.ranji.system.SystemContext;
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
		User u = new User("lisi", "456", -1, "测试用户");
		userDao.save(u);
		System.out.println(u.getId());
	}
	
	@Test
	public void testDeleteUser(){
		/*userDao.delete(9);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userName", "zhangsan");
		userDao.deleteAll(params);*/
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(11);
		ids.add(12);
		ids.add(15);
		userDao.deleteByIDS(ids);
	}
	
	@Test
	public void testFindUser(){
		
		User u = userDao.find(32);
		System.out.println(u);
		
		
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
	
	@Test   //-- 分页查找
	public void testFindPaginatedUser(){
		//-- 1. 不带查询条件的分页查询
		PagerModel<User> pm = userDao.findPaginated(null);
		System.out.println(pm.getTotal());
		//--2. 设置分页的偏移量和大小,不带查询条件
		SystemContext.setOffset(1);
		SystemContext.setPageSize(3);
		pm = userDao.findPaginated(null);
		System.out.println(pm.getTotal());
		for (User user : pm.getData()) {
			System.out.println(user);
		}
		//-- 3. 设置分页的偏移量和大小，并带查询条件
		SystemContext.setOffset(0);
		SystemContext.setPageSize(3);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userName", "zhangsan");
		params.put("enabled", -1);
		pm = userDao.findPaginated(params);
		System.out.println(pm.getTotal());
		for (User user : pm.getData()) {
			System.out.println(user);
		}
	}
}
