package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.ItemDao;
import com.heu.eam.dao.impl.ItemDaoImpl;
import com.heu.eam.dao.pojo.Item;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.ItemService;

public class ItemServiceImpl extends BaseServiceImpl<Item> implements
		ItemService {
	
	private ItemDao itemDao = new ItemDaoImpl();
	@Override
	public void save(Item item) {
		try {
			//转变成save
			//itemDao.saveItem(item);
			itemDao.save(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, Object> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map<String, Object>> findByPlaceId(Integer placeId) throws DaoException {
		return itemDao.findItemByPlaceId(placeId);
	}
}
	
	