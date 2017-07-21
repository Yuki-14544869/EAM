package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.eam.dao.TestDao;
import com.heu.eam.dao.pojo.Test;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;



public class TestDaoImpl extends BaseDaoImpl<Test> implements TestDao{

	public List<Test> findTestByCondition(String name,String count,
			String testcode, String testdate,String person) throws DaoException {
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<Test> result = new ArrayList<Test>();
		String sql ="select id,name,count,testdate,testcode,provid,person from test where 1=1";
	
		if(name!=null && name.length()>0){
			sql+=" and name like '%"+name+"%'";
		}
		if(count!=null && count.length()>0){
			sql+=" and count like '%"+count+"%'";
		}
		if(testcode!=null &&testcode.length()>0){
			sql+= "  and testcode like'%"+testcode+"%'";
		}
		if(testdate!=null && testdate.length()>0){
			sql+= "  and testdate like '%"+testdate+"%'";
		}
		if(person!=null && person.length()>0){
			sql+= "  and person like '%"+person+"%'";
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();System.out.println(sql);
			while(resultSet.next()){
				Test row = new Test();
				row.setId(resultSet.getInt("id"));
				row.setName(resultSet.getString("name"));
				row.setCount(resultSet.getString("count"));
				row.setTestcode(resultSet.getString("testcode"));
				row.setTestdate(resultSet.getString("testdate"));
				row.setPerson(resultSet.getString("person"));
				result.add(row);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}
	@Override
	public List<Test> findByName(String name) throws DaoException {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement =null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Test> result = new ArrayList<Test>();
		String sql ="select id,testdate from test where name = '" + name +"' order by testdate desc";
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Test row = new Test();
				row.setId(resultSet.getInt("id"));
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}
	
	
}

	
	
