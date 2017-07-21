package com.heu.eam.service;

import java.util.List;

import com.heu.eam.dao.pojo.Type;

public interface TypeService extends BaseService<Type>{

	  List<Type> findTypeByName(String name);
}
