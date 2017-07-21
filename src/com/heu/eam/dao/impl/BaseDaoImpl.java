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
import java.util.Set;

import com.heu.eam.dao.BaseDao;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;
import com.heu.eam.utils.DateUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {
	@Override
	public void save(T entry) throws DaoException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String time = DateUtil.dateToString(new Date());
		String sql = "insert into ";
		@SuppressWarnings("rawtypes")
		Class tagClass = entry.getClass();
		String tableName = tagClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
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

	@SuppressWarnings("rawtypes")
	@Override
	public void delete(Integer[] T, Class tableClass, Integer updateid)
			throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String time = DateUtil.dateToString(new Date());
		String sql = "update ";
		String tableName = tableClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		sql += tableName + " set del =1 ,updateid = '" + updateid
				+ "',updatetime = '" + time + "' where  id in ( ";
		for (Integer var : T) {
			sql += "'" + var + "' ,";
		}
		sql = sql.substring(0, sql.lastIndexOf(",")) + ")";
		System.out.println(sql);
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
	}

	@SuppressWarnings("rawtypes")
	public void update(Map<String, String> map, String updateid, Class tagClass,String version1,String id) throws DaoException, ServiceBusinessException {
		
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String time = DateUtil.dateToString(new Date());
		String sql = "update  ";
        int version = Integer.parseInt(version1);
		int newversion=version+1;
		String tableName = tagClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		sql += tableName + " set ";
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			sql+=string+"='"+map.get(string)+"',";
		}
		
		sql += "updateid='" + updateid + "',updatetime='" + time
				+ "',version='"+newversion+"' where id='"+id+"' and version ='"+version+"'" ;
		try {
			preparedStatement = connection.prepareStatement(sql);
			int executeUpdate = preparedStatement.executeUpdate();
			if(executeUpdate==0){
				throw new ServiceBusinessException("数据已经被修改，请刷新");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			CloseUtil.colseAll(preparedStatement, connection);
		}
			
	}
	
	

	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String, Object>> findAll(Class tableClass)
			throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		String sql = "select  ";
		String tableName = tableClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		Field[] fields = tableClass.getDeclaredFields();
		try {
			for (Field field : fields) {
				sql += field.getName() + " , ";
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += " from " + tableName+" where del ='0'";
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
	
	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>> findBy(Map<String, String> map,  Class tableClass)throws DaoException {
		// TODO Auto-generated method stub
				Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = null;
				List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
				String sql = "select  ";
				String tableName = tableClass.getName();
				tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
				Field[] fields = tableClass.getDeclaredFields();
				try {
					for (Field field : fields) {
						sql += field.getName() + " , ";
					}
					sql = sql.substring(0, sql.length() - 2);
					sql += "  from " + tableName + " where del = '0' ";
					if (map != null) {
						for (Map.Entry entry : map.entrySet()) {
							sql += " and " + entry.getKey();
							if (entry.getValue() == null) {
								sql += " = null";
							}
							else {
								sql += " like '%" + entry.getValue() + "%'";
							}
						}
					}
					
					
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

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Object> findById(int id, Class tableClass)
			throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		Map<String, Object> result = null;
		String sql = "select  ";
		String tableName = tableClass.getName();
		tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
		Field[] fields = tableClass.getDeclaredFields();
		try {
			for (Field field : fields) {

				sql += field.getName() + " , ";
			}
			sql = sql.substring(0, sql.length() - 2);
			sql += "  from " + tableName + " where id=?";
			System.out.println(sql);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = new HashMap<String, Object>();
				for (Field field : fields) {

					result.put(field.getName(),
							resultSet.getString(field.getName()));
				}
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
	
	
	
	
	
	
	public static void main(String[] args) {
		/*BaseDaoImpl<Role> baseDao =new BaseDaoImpl<Role>();
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", null);
		map.put("state", "4");
		Integer[] d={2,4,5};
		try {
			//baseDao.newupdate(map, 11, Role.class, 3, 7);
			//baseDao.save(new Role(0, "evan", null, null, 11, null, 11, null, 1));
			baseDao.findBy(map, Role.class);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}

}
