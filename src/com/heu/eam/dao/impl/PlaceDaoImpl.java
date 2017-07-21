package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.eam.dao.PlaceDao;
import com.heu.eam.dao.pojo.Place;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class PlaceDaoImpl extends BaseDaoImpl<Place> implements PlaceDao {
	@Override
	public List<Place> findByName(String name) throws DaoException {
		List<Place> placeList = new ArrayList<Place>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "select id from place where name=?";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Place place = new Place();
				place.setId(rs.getInt("id"));
				placeList.add(place);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return placeList;
	}


}
