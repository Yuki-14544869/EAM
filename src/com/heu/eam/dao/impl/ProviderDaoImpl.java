package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.eam.dao.ProviderDao;
import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class ProviderDaoImpl extends BaseDaoImpl<Provider> implements
		ProviderDao {

	@Override
	public List<Provider> findProviderByName(String name) throws DaoException  {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Provider> result = new ArrayList<Provider>();
		String sql = "select id,name from provider where name = '" + name+"'";
		System.out.println(sql);
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Provider row = new Provider();
				row.setId(resultSet.getInt("id"));
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CloseUtil.colseAll(preparedStatement, connection);
			}
		
		return result;
		
	}

	@Override
	public List<Provider> findProviderByCondition(String id, String name,
			String perid, String tel, String mail, String url, String address,
			String bankaccount) throws DaoException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Provider> result = new ArrayList<Provider>();
		String sql = "select id,name,perid,tel,mail,url,address,bankaccount from provider where 1=1 and del='0'";
		if (id != null) {
			sql += " and id like '%" + id + "%'";
		}
		if (name != null && name.length() > 0) {
			sql += " and name like '%" + name + "%'";
		}
		if (perid != null && perid.length() > 0) {
			sql += "  and sex='" + perid + "'";
		}
		if (tel != null && tel.length() > 0) {
			sql += "  and tel like '%" + tel + "%'";
		}
		if (url != null && url.length() > 0) {
			sql += "  and url like '%" + url + "%'";
		}
		if (address != null && address.length() > 0) {
			sql += "  and address like '%" + address + "%'";
		}
		if (bankaccount != null && bankaccount.length() > 0) {
			sql += "  and bankaccount like '%" + bankaccount + "%'";
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Provider row = new Provider();
				row.setId(resultSet.getInt("id"));
				row.setName(resultSet.getString("name"));
				row.setPerid(resultSet.getString("perid"));
				row.setTel(resultSet.getString("tel"));
				row.setMail(resultSet.getString("mail"));
				row.setUrl(resultSet.getString("url"));
				row.setAddress(resultSet.getString("address"));
				row.setBankaccount(resultSet.getString("bankaccount"));
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
