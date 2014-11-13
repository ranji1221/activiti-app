package org.ranji.activiti.service.common.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.ranji.activiti.model.pager.PagerModel;
import org.ranji.activiti.persist.common.prototype.IGenericDao;
import org.ranji.activiti.service.common.prototype.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {
	
	@Autowired
	protected IGenericDao<T, ID> dao;
	
	@Override
	public void save(T entity) {
		dao.save(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public void delete(ID oid) {
		dao.delete(oid);
	}

	@Override
	public void deleteAll(Map<String, Object> params) {
		dao.deleteAll(params);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public T find(ID oid) {
		return dao.find(oid);
	}

	@Override
	public List<T> findAll(Map<String, Object> params) {
		return dao.findAll(params);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public PagerModel<T> findPaginated(Map<String, Object> params) {
		return dao.findPaginated(params);
	}

}
