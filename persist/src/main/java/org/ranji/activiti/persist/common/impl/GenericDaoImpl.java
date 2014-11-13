package org.ranji.activiti.persist.common.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.ranji.activiti.model.pager.PagerModel;
import org.ranji.activiti.persist.common.prototype.IGenericDao;
import org.ranji.system.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 通用Dao接口实现类
 * @author RanJi
 * @since 2014-11-12
 * @version jdk7
 */
public abstract class GenericDaoImpl<T,ID extends Serializable> implements IGenericDao<T, ID> {
	
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	private Class<T> type;
	private String typeNameSpace;					//-- 定义MyBatis映射文件的名称空间
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		//-- 获取实际子类的Class对象
		type = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		typeNameSpace = type.getName();
	}
	
	//-- 保存实体类
	@Override
	public void save(T entity) {
		sqlSessionTemplate.insert(typeNameSpace+".save",entity);
	}
	
	//-- 更新实体类
	@Override
	public void update(T entity) {
		sqlSessionTemplate.update(typeNameSpace+".update", entity);
	}
	
	//-- 删除某个实体类
	@Override
	public void delete(Serializable oid) {
		sqlSessionTemplate.delete(typeNameSpace+".delete", oid);
	}
	
	//-- 删除全部实体类
	public void deleteAll() {
		deleteAll(null);
	}
	//-- 删除全部实体（设置删除的条件）
	@Override
	public void deleteAll(Map<String,Object> params) {
		sqlSessionTemplate.delete(typeNameSpace+".deleteAll",params);
	}
	
	//-- 查找某个实体
	@Override
	public T find(Serializable oid) {
		T entity =  sqlSessionTemplate.selectOne(typeNameSpace+".find", oid);
		return entity;
	}
	
	//-- 查找全部实体
	@Override
	public List<T> findAll() {
		return findAll(null);
	}
	//-- 查找全部实体 (设置查询条件)
	@Override
	public List<T> findAll(Map<String,Object> params) {
		List<T> entitys = sqlSessionTemplate.selectList(typeNameSpace+".findAll",params);
		return entitys;
	}
	
	@Override
	public PagerModel<T> findPaginated(Map<String,Object> params){
		//-- 1. 不管传或者不传参数都会追加至少两个分页参数
		if(params==null)
			params = new HashMap<String,Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		
		PagerModel<T> pm = new PagerModel<T>();		
		
		int total = getTotalNumOfItems(params);
		List<T> entitys = sqlSessionTemplate.selectList(typeNameSpace+".findPaginated", params);
		
		pm.setTotal(total);
		pm.setData(entitys);
		
		return pm;
	}	
	
	//-- 获取总的条目数 (分页查询中使用)
	private int getTotalNumOfItems(Map<String,Object> params){
		int count = (Integer)sqlSessionTemplate.selectOne(typeNameSpace+".getTotalNumOfItems", params);
		return count;
	}
}
