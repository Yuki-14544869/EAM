package com.heu.eam.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.heu.eam.exception.DaoException;

public class CloseUtil {

	public static void colseAll(PreparedStatement preparedStatement,
			Connection connection) throws DaoException {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DaoException("关闭容器发生异常");
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DaoException("关闭连接发生异常");
			}

		}
	}
}
