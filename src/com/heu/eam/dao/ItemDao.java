package com.heu.eam.dao;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Item;
import com.heu.eam.exception.DaoException;

public interface ItemDao extends BaseDao<Item> {
	List<Map<String, Object>> findItemByPlaceId(int placeId) throws DaoException;
	void saveItem(Item item) throws Exception;
	void deleteItem(Item entry) throws DaoException;
}
