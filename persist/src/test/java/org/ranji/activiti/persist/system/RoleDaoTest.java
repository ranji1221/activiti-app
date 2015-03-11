package org.ranji.activiti.persist.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.activiti.model.pager.PagerModel;
import org.ranji.activiti.model.system.Role;
import org.ranji.activiti.persist.system.prototype.IRoleDao;
import org.ranji.system.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * roleDao测试类
 * @author RanJi
 * @since 2014-11-12
 * @version jdk7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-persist.xml")
public class RoleDaoTest {
	
	@Autowired
	private IRoleDao roleDao;
	
	@Before
	public void init(){}
	
	@Test
	public void testAddRole(){
		Role r = new Role("test", "测试用户");
		roleDao.save(r);
		System.out.println(r.getId());
	}
	
	@Test
	public void testDeleteRole(){
		/*roleDao.delete(9);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("RoleName", "zhangsan");
		roleDao.deleteAll(params);*/
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(12);
		ids.add(15);
		roleDao.deleteByIDS(ids);
	}
	
	@Test
	public void testFindRole(){
		
		Role r = roleDao.find(2);
		System.out.println(r);
		
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", "zhangsan");
		//params.put("enabled", -1);
		List<Role> Roles = roleDao.findAll(params);
		System.out.println(Roles.size());
		
		Roles = roleDao.findAll();
		for (Role Role : Roles) {
			System.out.println(Role);
		}
	}
	
	@Test   //-- 分页查找
	public void testFindPaginatedRole(){
		//-- 1. 不带查询条件的分页查询
		PagerModel<Role> pm = roleDao.findPaginated(null);
		System.out.println(pm.getTotal());
		//--2. 设置分页的偏移量和大小,不带查询条件
		SystemContext.setOffset(1);
		SystemContext.setPageSize(3);
		pm = roleDao.findPaginated(null);
		System.out.println(pm.getTotal());
		for (Role Role : pm.getData()) {
			System.out.println(Role);
		}
		//-- 3. 设置分页的偏移量和大小，并带查询条件
		SystemContext.setOffset(0);
		SystemContext.setPageSize(3);
		Map<String,Object> params = new HashMap<String,Object>();
		//params.put("RoleName", "zhangsan");
		//params.put("enabled", -1);
		pm = roleDao.findPaginated(params);
		System.out.println(pm.getTotal());
		for (Role Role : pm.getData()) {
			System.out.println(Role);
		}
	}
}
