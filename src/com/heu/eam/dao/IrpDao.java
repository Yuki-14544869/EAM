package com.heu.eam.dao;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Irp;
import com.heu.eam.exception.DaoException;

public interface IrpDao extends BaseDao<Irp>{
	List<Irp> findByName(String name) throws DaoException;
	Map<String, Object> findByPid(int code) throws DaoException;
	Map<String, Object> findByDel(String del) throws DaoException;
	List<Map<String, Object>> findAll()throws DaoException;
}