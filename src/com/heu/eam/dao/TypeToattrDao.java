package com.heu.eam.dao;

import java.util.List;

import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.dao.pojo.TypeToattr;

public interface TypeToattrDao extends BaseDao<TypeToattr>{
	 List<TypeToattr> findAttributeByTypeId(int typeid);
	 List<TypeToattr> findTypeByAttrid(int attrid) ;
	 void saveTypeToattr(Type type, Attribute attribute);
	 void deleteTypeToattrBytypeid(int id);
}
