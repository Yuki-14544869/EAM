package com.heu.eam.service;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Item;
import com.heu.eam.exception.DaoException;

public interface ItemService extends BaseService<Item> {


	List<Map<String, Object>> findByPlaceId(Integer placeId)
			throws DaoException;

	void save(Item item);

	Map<String, Object> findById(int id);
}
