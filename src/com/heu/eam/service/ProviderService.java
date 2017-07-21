package com.heu.eam.service;

import java.util.List;

import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.exception.DaoException;

public interface ProviderService extends BaseService<Provider>{
	List<Provider> findProviderName(String name)throws DaoException;
	List<Provider> findProviderByCondition(String id,String name,String perid,String tel,String mail,String url,String address,String bankaccount)throws DaoException;
	//void save(Provider provider) throws DaoException ;
	// void dropProvider(int id);
     //void updateProvider(Provider provider);
	
	}
