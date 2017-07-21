package com.heu.eam.dao;

import java.util.List;

import com.heu.eam.dao.pojo.Test;
import com.heu.eam.exception.DaoException;


public interface TestDao extends BaseDao<Test>{
	
	  List<Test> findTestByCondition(String name,String count,String testcode,String testdate,String person) throws DaoException;
	  List<Test> findByName(String name) throws DaoException;
}
