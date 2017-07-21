package com.heu.eam.utils;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.heu.eam.exception.DaoException;

public class DBUtil {
	private static String ip;
	private static String port;
	private static String dbName;
	private static String userName;
	private static String password;

	
	public static Connection getConnection() throws DaoException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@" + ip
					+ ":" + port + ":" + dbName, userName, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("数据库连接异常");
		}
		return connection;
	}

	public static void init(InputStream fileInputStream) throws DaoException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties properties = new Properties();
			properties.loadFromXML(fileInputStream);
			ip = properties.getProperty("ip");
			port = properties.getProperty("port");
			dbName = properties.getProperty("dbName");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new DaoException("数据库驱动不存在");
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			throw new DaoException("XML格式异常");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DaoException("输入输出流异常");
		}
	}
}
