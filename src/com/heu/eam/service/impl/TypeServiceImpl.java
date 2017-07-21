package com.heu.eam.service.impl;

import java.util.List;

import com.heu.eam.dao.TypeDao;
import com.heu.eam.dao.factory.DaoFactory;
import com.heu.eam.dao.impl.TypeDaoImpl;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.service.TypeService;

public class TypeServiceImpl  extends BaseServiceImpl<Type> implements TypeService{

	private TypeDao TD=new TypeDaoImpl();
	
	
	public List<Type> findTypeByName(String name) {
		
		
		return TD.findTypeByName(name);
}
	
}
