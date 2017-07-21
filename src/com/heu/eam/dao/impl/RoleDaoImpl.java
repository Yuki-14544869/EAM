package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.eam.dao.RoleDao;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public List<Role> findByElement(String id, String name,String state)  {
		Connection connection= null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		List<Role> result = new ArrayList<Role>();
		String sql ="select id,name,state  from role where 1=1 and del=0 and id<>1";
		System.out.println(id);
		if(id!=null && id.length()>0){
			sql+= " and id like '%"+id+"%'";
		}
		if(name!=null && name.length()>0){
			sql+=" and name like '%"+name+"%'";
		}
		if(state!=null && state.length()>0){
			sql+= "  and state='"+state+"'";
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(sql);
			while(resultSet.next()){
				Role row=new Role();
				row.setId(resultSet.getInt("id"));
				row.setName(resultSet.getString("name"));
				row.setState(resultSet.getString("state"));
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
