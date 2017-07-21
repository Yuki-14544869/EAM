package com.heu.eam.service;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Person;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;

public interface PersonService extends BaseService<Person>{

	Map<String, Map<String, String>> getIrp(String id)throws DaoException;
	
	
	Map<String,Object> textLogin(String userName,String password)throws ServiceBusinessException;

}
