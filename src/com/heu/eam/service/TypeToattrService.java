
	package com.heu.eam.service;

	import java.util.List;

	import com.heu.eam.dao.pojo.Attribute;
	import com.heu.eam.dao.pojo.Type;
	import com.heu.eam.dao.pojo.TypeToattr;

	public interface TypeToattrService extends BaseService<TypeToattr>{
		List<TypeToattr>findAttributeByTypeId(int typeid);
		List<TypeToattr>findTypeByAttrId(int attrid);
		void saveTypeToattr(Type type,Attribute attribute);
		
	}


