package com.heu.eam.service.impl;

import java.util.List;

import com.heu.eam.dao.AttributeDao;
import com.heu.eam.service.AttributeService;
import com.heu.eam.dao.impl.AttributeDaoImpl;
import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.exception.DaoException;

public class AttributeServiceImpl extends BaseServiceImpl<Attribute> implements AttributeService{
	private AttributeDao dao = new AttributeDaoImpl();
		
	@Override
	public List<Attribute> findAttributeByName(String name) throws DaoException {
		// TODO Auto-generated method stub
		return dao.findAttributeByName(name);
	}

	@Override
	public List<Attribute> findAttributeByCondition(String id, String name)
			throws DaoException {
		// TODO Auto-generated method stub
		return dao.findAttributeByCondition(id, name);
	}
	
	
}
