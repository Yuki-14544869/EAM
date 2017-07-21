package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.PlanDao;
import com.heu.eam.dao.impl.PlanDaoImpl;
import com.heu.eam.dao.pojo.Plan;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.PlanService;

public class PlanServiceImpl extends BaseServiceImpl<Plan> implements PlanService{

	private PlanDao dao = new PlanDaoImpl();
	
	@Override
	public List<Map<String, Object>> findByState(int State, int sdid, Class tableclass) throws DaoException {
		List<Map<String, Object>> resultlist = dao.findByState(State, sdid, tableclass);
		return resultlist;
	}
	
	public List<Map<String, Object>> findMyplan(int State, int cdid, Class tableclass) throws DaoException {
		List<Map<String, Object>> resultlist = dao.findMyplan(State, cdid, tableclass);
		return resultlist;
	}


	public void delete(int id, Integer updateid) throws DaoException {
		dao.delete(id, updateid);
	}
	
	public void save(Plan entry) throws DaoException {
		dao.save(entry);
	}
}
