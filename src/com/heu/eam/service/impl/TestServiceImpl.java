package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.PersonDao;
import com.heu.eam.dao.TestDao;
import com.heu.eam.dao.factory.DaoFactory;
import com.heu.eam.dao.impl.PersonDaoImpl;
import com.heu.eam.dao.impl.TestDaoImpl;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.dao.pojo.Test;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.TestService;


public class TestServiceImpl extends BaseServiceImpl<Test> implements TestService {
	private TestDao testDao=DaoFactory.getTestDao();

	@Override
	public List<Test> findTestByCondition(String name, String count,String testcode,
			String testdate, String person) throws DaoException {
		return testDao.findTestByCondition(name, count,testcode, testdate, person);
	}
	@Override
	public List<Test> findByName(String name) throws DaoException  {
		
		return testDao.findByName(name);
	}
	
	

}
