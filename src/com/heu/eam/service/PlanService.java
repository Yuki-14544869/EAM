package com.heu.eam.service;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Plan;
import com.heu.eam.exception.DaoException;




public interface PlanService extends BaseService<Plan> {

	public List<Map<String, Object>> findByState(int State,int sdid,Class tableclass)throws DaoException;
	
	public List<Map<String, Object>> findMyplan(int State,int cdid,Class tableclass)throws DaoException;

	public void delete(int id, Integer updateid) throws DaoException;
	
	public void save(Plan entry) throws DaoException;
}
