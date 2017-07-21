package com.heu.eam.service;

import java.util.List;

import com.heu.eam.dao.pojo.Place;
import com.heu.eam.exception.DaoException;


public interface PlaceService extends BaseService<Place> {
      List<Place> findPlaceByName(String name)  throws DaoException;
	 
}
