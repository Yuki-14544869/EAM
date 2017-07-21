package com.heu.eam.service;

import java.util.List;

import com.heu.eam.dao.pojo.Role;
import com.heu.eam.dao.pojo.Test;
import com.heu.eam.exception.DaoException;

public interface TestService extends BaseService<Test>{
	
	List<Test> findTestByCondition(String name,String count,String testcode,String testdate,String person)throws DaoException;

	List<Test> findByName(String name)throws DaoException;

}
