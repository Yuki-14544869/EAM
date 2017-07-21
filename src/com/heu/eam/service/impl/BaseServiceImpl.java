package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.BaseDao;
import com.heu.eam.dao.impl.BaseDaoImpl;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> dao = new BaseDaoImpl<T>();
	@Override
	public void save(T entry) throws DaoException {
		// TODO Auto-generated method stub
		dao.save(entry);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void delete(Integer[] T, Class tableClass, Integer updateid)
			throws DaoException {
		// TODO Auto-generated method stub
		dao.delete(T, tableClass, updateid);
	}

	@Override
	public void  update(Map<String, String> map, String updateid,Class tagClass,String version,String id)throws DaoException,ServiceBusinessException {
		// TODO Auto-generated method stub
		dao.update(map, updateid,tagClass, version,id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String, Object>> findAll(Class tableClass)
			throws DaoException {
		// TODO Auto-generated method stub
		return dao.findAll(tableClass);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Object> findById(int id, Class tableClass)
			throws DaoException {
		// TODO Auto-generated method stub
		return dao.findById(id, tableClass);
	}

	@Override
	public List<Map<String, Object>> findBy(Map<String, String> map,
			Class tableClass) throws DaoException {
		// TODO Auto-generated method stub
		return dao.findBy(map, tableClass);
	}

}
