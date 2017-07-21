package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.eam.dao.TypeDao;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class TypeDaoImpl extends BaseDaoImpl<Type> implements TypeDao{

	@Override
	public List<Type> findTypeByName(String name) {
		  Connection connection=null;
	  		PreparedStatement preparedStatement =null;
	  		try {
				connection = DBUtil.getConnection();
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  		List<Type> result = new ArrayList<Type>();
	  		String sql ="select id,name,detail,version  from type where del=0 and name like'%";
	  		if(name!=null&&name.length()>0) {
	  			sql+=name+"%'";
	  		}else{
	  			sql+="%'";
	  		}
	  		System.out.println(sql);
	  		try {
	  			preparedStatement = connection.prepareStatement(sql);
	  			ResultSet	resultSet = preparedStatement.executeQuery();
	  			while(resultSet.next()) {
	  				Type type=new Type();
	  				type.setId(resultSet.getInt("id"));
	  				type.setName(resultSet.getString("name"));
	  				type.setDetail(resultSet.getString("detail"));
	  				type.setVersion(resultSet.getInt("version"));
	  				result.add(type);
	  				}
	  		} catch (SQLException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		
	  		}finally{
				try {
					CloseUtil.colseAll(preparedStatement, connection);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	  		
	   	 return result;
}

	@Override
	public void deleteByName(Type type) {
		Connection connection=null;
  		PreparedStatement preparedStatement =null;
  		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		String sql="delete type where name='";
  		if(type.getName()!=null){
  			sql+=type.getName()+"'";
  		}
  	
			try {
				preparedStatement = connection.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					CloseUtil.colseAll(preparedStatement, connection);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}
	@Override
	public int findTypeidByname(String name) {
		 Connection connection=null;
	  		PreparedStatement preparedStatement =null;
	  		int id=0;
	  		try {
				connection = DBUtil.getConnection();
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	  		String sql="select id from type where name='";
	  		sql+=name+"'";
	  	
	  			try {
					preparedStatement = connection.prepareStatement(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  			ResultSet resultSet;
				try {
					resultSet = preparedStatement.executeQuery();
					id=resultSet.getInt("id");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						CloseUtil.colseAll(preparedStatement, connection);
					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		return id;
	
	}
}
