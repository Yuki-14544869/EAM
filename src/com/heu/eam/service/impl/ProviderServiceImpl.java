package com.heu.eam.service.impl;

import java.util.List;

import com.heu.eam.dao.ProviderDao;
import com.heu.eam.dao.impl.ProviderDaoImpl;
import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.ProviderService;

public class ProviderServiceImpl extends BaseServiceImpl<Provider> implements
		ProviderService {
	private ProviderDao providerdao = new ProviderDaoImpl();

	@Override
	public List<Provider> findProviderByCondition(String id, String name,
			String perid, String tel, String mail, String url, String address,
			String bankaccount) throws DaoException {
		return providerdao.findProviderByCondition(id, name, perid, tel, mail, url, address, bankaccount);
	}

	

	@Override
	public List<Provider> findProviderName(String name) throws DaoException {
		// TODO Auto-generated method stub
		return providerdao.findProviderByName(name);
	}

}
