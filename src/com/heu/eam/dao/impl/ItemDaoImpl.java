package com.heu.eam.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heu.eam.dao.ItemDao;
import com.heu.eam.dao.pojo.Item;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class ItemDaoImpl extends BaseDaoImpl<Item> implements ItemDao {

	@Override
	public List<Map<String, Object>> findItemByPlaceId(int placeId)
			throws DaoException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String sql = "select ";
		String tableName = Item.class.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		Field[] fields = Item.class.getDeclaredFields();
		try {
			for (Field field : fields) {
				sql += field.getName() + " , ";
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += " from " + tableName;
			sql += " where placeId = " + placeId;
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Map<String, Object> column = new HashMap<String, Object>();
				for (Field field : fields) {
					column.put(field.getName(),
							resultSet.getString(field.getName()));
				}
				result.add(column);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new DaoException("存在不合法的参数");
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}

	@Override
	public void saveItem(Item entry) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBUtil.getConnection();
		String sql = "insert into ";
		@SuppressWarnings("rawtypes")
		Class tagClass = entry.getClass();

		String tableName = tagClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		sql += tableName
				+ "(name,price,placeid,deptid,testid,buyername,provid,typeid,enterdate,del,createId,createtime,updateid,updatetime,version)"
				+ " values (";
		Field[] fields = tagClass.getDeclaredFields();
		try {
			for (Field field : fields) {
				if ("id".equals(field.getName()))
					continue;
				field.setAccessible(true);
				String value = String.valueOf(field.get(entry));
				sql += "'" + value + "' , ";
				field.setAccessible(false);
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += ")";
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("BaseDaoImpl save exception", e);
		} catch (IllegalArgumentException e) {
			throw new DaoException("get object data exception", e);
		} catch (IllegalAccessException e) {

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void deleteItem(Item entry) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBUtil.getConnection();
		String sql = "delete from  ";
		@SuppressWarnings("rawtypes")
		Class tagClass = entry.getClass();

		String tableName = tagClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		sql += tableName + " where id= " + entry.getId();
		try {
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
