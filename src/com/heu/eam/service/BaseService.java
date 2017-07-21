package com.heu.eam.service;

import java.util.List;
import java.util.Map;

import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;

public interface BaseService<T> {

	public void save(T entry)throws DaoException ;

	@SuppressWarnings("rawtypes")
	public void delete(Integer[] T,Class tableClass,Integer updateid)throws DaoException;

	public void update(Map<String, String> map, String updateid,Class tagClass,String version,String id)throws DaoException,ServiceBusinessException;

	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>> findAll(Class tableClass)throws DaoException;

	@SuppressWarnings("rawtypes")
	public Map<String, Object> findById(int id, Class tableClass)throws DaoException;
	
	public List<Map<String, Object>> findBy(Map<String, String> map, Class tableClass)throws DaoException;
}
