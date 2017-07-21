package com.heu.eam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.DBUtil;

public class loginService {
	public static Connection getLoign(String username,String password) throws DaoException {

    Connection connection = DBUtil.getConnection();
	String sql="select *form person where username=? and password=?";
	PreparedStatement pstmt = null;
	try {
		pstmt = connection.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setString(1, username);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setString(2, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	}
}

