package org.ranji.activiti.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.activiti.model.pager.PagerModel;
import org.ranji.activiti.model.system.User;
import org.ranji.activiti.service.system.prototype.IUserService;
import org.ranji.system.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *  UserService测试
 * @author RanJi
 * @since 2014-11-13
 * @version jdk7
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-persist.xml","classpath:spring-service.xml"})
public class UserServiceTest {
	@Autowired
	private IUserService userSerivce;
	
	@Test
	public void testAddUser(){
		User u = new User("zhangsan", "456", -1, "测试用户");
		userSerivce.save(u);
		System.out.println(u.getId());
	}
	
	@Test
	public void testDeleteUser(){
		userSerivce.delete(9);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userName", "zhangsan");
		userSerivce.deleteAll(params);
	}
	
	@Test
	public void testFindUser(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userName", "zhangsan");
		params.put("enabled", -1);
		List<User> users = userSerivce.findAll(params);
		System.out.println(users.size());
		
		users = userSerivce.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test   //-- 分页查找
	public void testFindPaginatedUser(){
		//-- 1. 不带查询条件的分页查询
		PagerModel<User> pm = userSerivce.findPaginated(null);
		System.out.println(pm.getTotal());
		//--2. 设置分页的偏移量和大小,不带查询条件
		SystemContext.setOffset(1);
		SystemContext.setPageSize(3);
		pm = userSerivce.findPaginated(null);
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
		pm = userSerivce.findPaginated(params);
		System.out.println(pm.getTotal());
		for (User user : pm.getData()) {
			System.out.println(user);
		}
	}
}
