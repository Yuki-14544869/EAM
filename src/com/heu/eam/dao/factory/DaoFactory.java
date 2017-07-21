package com.heu.eam.dao.factory;

import com.heu.eam.dao.ProviderDao;
import com.heu.eam.dao.TestDao;
import com.heu.eam.dao.impl.ProviderDaoImpl;
import com.heu.eam.dao.impl.TestDaoImpl;



public class DaoFactory {
	
	public static TestDao getTestDao() {
		// TODO Auto-generated method stub
		return new TestDaoImpl();
	}
}
