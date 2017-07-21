package com.heu.eam.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.heu.eam.dao.PlanDao;
import com.heu.eam.dao.pojo.Plan;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;
import com.heu.eam.utils.DateUtil;

public class PlanDaoImpl extends BaseDaoImpl<Plan> implements PlanDao{
	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>>  findByState(int state, int sdid,Class tableClass)
			throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		List<Map<String, Object>>  result = new ArrayList<Map<String,Object>>();
		String sql = "select  ";
		String tableName = tableClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		Field[] fields = tableClass.getDeclaredFields();
		try {
			for (Field field : fields) {

				sql += field.getName() + " , ";
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += "  from " + tableName + " where state=? and sdid=? and del='0'";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,state);
			preparedStatement.setInt(2,sdid);
			System.out.println(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				System.out.println("提取到一行数据");
				for (Field field : fields) {

					row.put(field.getName(),
							resultSet.getString(field.getName()));
				}
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("存在不合法的参数");
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}
	
	public List<Map<String, Object>>  findMyplan(int state, int cdid,Class tableClass)
			throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		List<Map<String, Object>>  result = new ArrayList<Map<String,Object>>();
		String sql = "select  ";
		String tableName = tableClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		Field[] fields = tableClass.getDeclaredFields();
		try {
			for (Field field : fields) {

				sql += field.getName() + " , ";
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += "  from " + tableName + " where state=? and cdid=? and del='0'";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,state);
			preparedStatement.setInt(2,cdid);
			System.out.println(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				System.out.println("提取到一行数据");
				for (Field field : fields) {

					row.put(field.getName(),
							resultSet.getString(field.getName()));
				}
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("存在不合法的参数");
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}
	
	public void delete(int id, Integer updateid)
			throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String time = DateUtil.dateToString(new Date());
		String sql = "update ";
		String tableName = "plan";
		//tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		sql += tableName + " set del =1 ,updateid = '" + updateid
				+ "',updatetime = '" + time + "' where  id ='" + id + "'";
		System.out.println(sql);
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
	}
	
	public void save(Plan entry) throws DaoException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String time = DateUtil.dateToString(new Date());
		String sql = "insert into ";
		@SuppressWarnings("rawtypes")
		Class tagClass = entry.getClass();
		//String tableName = tagClass.getName();
		//tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		String tableName = "plan";
		sql += tableName + " (";
		Field[] fields = tagClass.getDeclaredFields();
		for (Field field : fields) {
			String colName = field.getName();
			sql += colName + " , ";
		}
		sql = sql.substring(0, sql.lastIndexOf(",")) + ") values (";
		try {
			for (int i = 0; i < fields.length - 5; i++) {
				
				Field field = fields[i];
				if(field.getName().equals("id")){
					sql+="allseq.nextval ,";
					continue;
				}
				
				
				field.setAccessible(true);
				String value;
				Object temp = field.get(entry);
				if (temp != null) {
					value = String.valueOf(temp);
					value = "'" + value + "' , ";
				} else {
					value = "null , ";
				}
				sql += value;
				field.setAccessible(false);
			}
			Field createidfField = tagClass.getDeclaredField("createId");
			createidfField.setAccessible(true);
			String createid = String.valueOf(createidfField.get(entry));
			createidfField.setAccessible(false);
			sql += "'" + createid + "','" + time + "','" + createid + "','"
					+ time + "','1')";
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("存在不合法的参数");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("无权限访问私有化属性或方法");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
	}

	
	
}
