package com.heu.eam.dao;

import java.util.List;

import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.exception.DaoException;


public interface ProviderDao extends BaseDao<Provider> {
	
	
		List<Provider> findProviderByCondition(String id,String name,String perid,String tel,String mail,String url,String address,String bankaccount)throws DaoException;
	    List<Provider> findProviderByName(String name)throws DaoException;
}
