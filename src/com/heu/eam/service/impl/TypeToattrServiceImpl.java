package com.heu.eam.service.impl;

import java.util.List;


import com.heu.eam.dao.TypeToattrDao;

import com.heu.eam.dao.impl.TypeToattrDaoImpl;
import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.dao.pojo.TypeToattr;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.TypeToattrService;

public class TypeToattrServiceImpl extends BaseServiceImpl<TypeToattr> implements TypeToattrService {
	private TypeToattrDao TT=new TypeToattrDaoImpl();
		public List<TypeToattr>findAttributeByTypeId(int typeid){
		
		return TT.findAttributeByTypeId(typeid);
	}
	@Override
	public List<TypeToattr> findTypeByAttrId(int attrid) {
		
		return TT.findTypeByAttrid(attrid);
	}
	@Override
	public void saveTypeToattr(Type type,Attribute attribute) {
	  
	   TT.saveTypeToattr(type, attribute);
		
	}
}

