package com.heu.eam.dao;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Plan;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;
import com.heu.eam.utils.DateUtil;

public interface PlanDao extends BaseDao<Plan>{
	
	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>>  findByState(int State,int sdid , Class tableClass)throws DaoException;
	
	public List<Map<String, Object>>  findMyplan(int State,int cdid , Class tableClass)throws DaoException;
	
	public void save(Plan entry) throws DaoException;

	public void delete(int id, Integer updateid) throws DaoException;

	
}
