package com.heu.eam.dao;

import java.util.List;

import com.heu.eam.dao.pojo.Type;

public interface TypeDao extends  BaseDao<Type>{
       List<Type> findTypeByName(String name);
       void deleteByName(Type type);
       int findTypeidByname(String name);
   }

