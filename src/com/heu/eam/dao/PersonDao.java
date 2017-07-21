package com.heu.eam.dao;

import java.util.Map;

import com.heu.eam.dao.pojo.Person;
import com.heu.eam.exception.DaoException;

public interface PersonDao extends BaseDao<Person>{
	
	public Map<String, Map<String, String>> getIrp(String id)throws DaoException;
   
	public Map<String,Object> textLogin(String userName,String password) throws DaoException;
	
}
