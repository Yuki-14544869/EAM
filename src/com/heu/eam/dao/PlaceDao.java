package com.heu.eam.dao;

import java.util.List;

import com.heu.eam.dao.pojo.Place;
import com.heu.eam.exception.DaoException;


public interface PlaceDao extends BaseDao<Place> {

	List<Place> findByName(String name)  throws DaoException;


}
