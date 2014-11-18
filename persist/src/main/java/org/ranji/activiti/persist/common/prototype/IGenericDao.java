package org.ranji.activiti.persist.common.prototype;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.ranji.activiti.model.pager.PagerModel;

/**
 * 通用Dao接口设计
 * @author RanJi
 * @since 2014-11-12 am
 * @version jdk7
 */
public interface IGenericDao<T, ID extends Serializable> {

	public void save(T entity);
	public void update(T entity);	
	/**
	 * 根据对象ID删除数据
	 * @param oid ID(主键值)
	 */
	public void delete(ID oid);		
	/**
	 * 删除全部数据条目，可以设置条件，亦可以不设置删除条件
	 * 不设置删除条件就默认全部的删除
	 * @param params
	 */
	public void deleteAll(Map<String,Object> params);
	public void deleteAll();
	/**
	 * 根据给定的用户的ID的集合，删除用户
	 * @param ids ID的集合
	 */
	public void deleteByIDS(List<ID> ids);
	/**
	 *  根据对象ID查询数据
	 * @param oid   ID (主键值)
	 * @return 对象
	 */
	public T find(ID oid);
	
	/**
	 * 查询全部的数据，可以设置条件，亦可以不设置查询条件
	 * @param params	 设置条件查询的参数
	 * @return 对象集合
	 */
	public List<T> findAll(Map<String,Object> params);
	public List<T> findAll();
	
	/**
	 * 分页查询
	 * @param params		查询的条件参数
	 * @param methodName  mybatis配置文件中所配置的方法名程
	 * @return 所要的分页数据
	 */
	public PagerModel<T> findPaginated(Map<String,Object> params);
	
}
