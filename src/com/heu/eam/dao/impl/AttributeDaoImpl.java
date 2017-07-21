package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.r;

import com.heu.eam.dao.AttributeDao;
import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class AttributeDaoImpl extends BaseDaoImpl<Attribute> implements AttributeDao{
	
	@Override
	public List<Attribute> findAttributeByName(String name) throws DaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Attribute> result = new ArrayList<Attribute>();
		
		
		String sql = "select name from attribute where 1=1";
		if(name!=null && name.length()>0){
			sql+=" and name like '%"+name+"%'";
		}try{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Attribute row = new Attribute();
				row.setName(resultSet.getString("name"));
				result.add(row);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{				
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}

	@Override
	public List<Attribute> findAttributeByCondition(String id, String name) throws DaoException {
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		connection = DBUtil.getConnection();
		List<Attribute> result = new ArrayList<Attribute>();
		String sql ="select id,name from attribute where 1=1";
		if(id!=null && id.length()>0){
			sql+= " and id like '%"+id+"%'";
		}
		if(name!=null && name.length()>0){
			sql+=" and name like '%"+name+"%'";
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Attribute row = new Attribute();
				row.setId(resultSet.getInt("id"));
				row.setName(resultSet.getString("name"));
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{				
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}
}
