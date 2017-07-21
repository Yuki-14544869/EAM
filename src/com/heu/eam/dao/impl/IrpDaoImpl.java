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

import com.heu.eam.dao.IrpDao;
import com.heu.eam.dao.pojo.Irp;
import com.heu.eam.dao.pojo.PersonToRole;
import com.heu.eam.dao.pojo.Place;
import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class IrpDaoImpl extends BaseDaoImpl<Irp> implements IrpDao {

	public List<Irp> findByName(String cname) {
		List<Irp> List = new ArrayList<Irp>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String sql = null;
		System.out.println("函数-------------------");
		try {
			connection = DBUtil.getConnection();
			sql = "select * from irp where cname like '%" + cname + "%'";
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cname);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Irp i = new Irp();
				i.setId(resultSet.getInt("id"));
				i.setCname(resultSet.getString("cname"));
				i.setDetal(resultSet.getString("detal"));
				i.setDel(resultSet.getString("del"));
				List.add(i);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (DaoException e) {

			e.printStackTrace();
		} finally {

			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {

				e.printStackTrace();
			}
		}
		return List;

	}

	public Map<String, Object> findByPid(int code) throws DaoException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;// 根据一级菜单查询二级菜单
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String sql = "select * from irp where code=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, code);
			ResultSet rs = preparedStatement.executeQuery();
			Irp i = new Irp();
			if (rs.next()) {
				String m = Integer.toBinaryString(rs.getInt("code"));

				i.setId(rs.getInt("id"));
				i.setCname(rs.getString("cname"));
				i.setDetal(rs.getString("detal"));
				i.setDel(rs.getString("del"));
				i.setCode(rs.getInt("code"));
				 result.put("BBB", i);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);

		}
		return result;
	}

	public Map<String, Object> findByDel(String del) throws DaoException {
		Connection connection = DBUtil.getConnection();// 查询显示的菜单或者隐藏的菜单
		PreparedStatement preparedStatement = null;
		Map<String, Object> result = new HashMap<String,Object>();
		Irp i = new Irp();
		try {
			String sql = "select * from irp where del=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, del);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				String m = rs.getString("del");
				i.setId(rs.getInt("id"));
				i.setCname(rs.getString("cname"));
				i.setDetal(rs.getString("detal"));
				i.setDel(rs.getString("del"));
				i.setCode(rs.getInt("code"));
				i.setState(rs.getString("state"));
				 result.put("CCC", i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("SQL异常");
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);

		}
		return result;
	}

	public List<Map<String, Object>> findAll()
			throws DaoException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();	
			Map<String, Object> column = new HashMap<String, Object>();
			Irp i = new Irp();
			try {
		         String sql = "select * from irp ";
		         preparedStatement = connection.prepareStatement(sql);
		         System.out.println(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				String i1="1";
			while (resultSet.next()) {
				
					column.put(i1,
							resultSet.getString("cname"));
					System.out.println(resultSet.getString("cname"));
					int a=Integer.parseInt(i1);a++;
					i1=String.valueOf(a);
				}
				result.add(column);
			
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
	
}
