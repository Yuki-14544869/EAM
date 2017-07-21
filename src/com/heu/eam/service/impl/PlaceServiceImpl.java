package com.heu.eam.service.impl;

import java.util.List;

import com.heu.eam.dao.PlaceDao;
import com.heu.eam.dao.impl.PlaceDaoImpl;
import com.heu.eam.dao.pojo.Place;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.PlaceService;

public class PlaceServiceImpl extends BaseServiceImpl<Place> implements
		PlaceService {
	
	private PlaceDao placeDao = new PlaceDaoImpl();

	@Override
	public List<Place> findPlaceByName(String name) throws DaoException {		
		return placeDao.findByName(name);
	}

	
	
}
