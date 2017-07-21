package com.heu.eam.service;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Irp;
import com.heu.eam.exception.DaoException;

public interface IrpService extends BaseService<Irp>{
	List<Irp> findByName(String name) throws DaoException;
	Map<String, Object>findByPid(int pid) throws DaoException;
	Map<String, Object> findByDel(String del) throws DaoException;
	List<Map<String, Object>> findAll() throws DaoException;
}
