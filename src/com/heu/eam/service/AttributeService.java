package com.heu.eam.service;

import java.util.List;

import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.exception.DaoException;

public interface AttributeService extends BaseService<Attribute> {
	List<Attribute> findAttributeByName(String name) throws DaoException;
	List<Attribute> findAttributeByCondition(String id,String name) throws DaoException;
}
