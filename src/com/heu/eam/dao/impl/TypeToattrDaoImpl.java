package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.eam.dao.AttributeDao;
import com.heu.eam.dao.TypeDao;
import com.heu.eam.dao.TypeToattrDao;
import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.dao.pojo.TypeToattr;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class TypeToattrDaoImpl extends BaseDaoImpl<TypeToattr> implements
		TypeToattrDao {

	@Override
	public List<TypeToattr> findAttributeByTypeId(int typeid) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TypeToattr> result = new ArrayList<TypeToattr>();
		String sql = "select id,name,details from attribute where id =";
		sql += "( select attrid from typetoattr where ";
		if (typeid != 0) {
			sql += "typeid like '%" + typeid + "%'";
		}
		sql += ")";
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				TypeToattr FAT = new TypeToattr();
				FAT.setId(resultSet.getInt("id"));
				FAT.setTypeid(resultSet.getInt("typeid"));
				FAT.setAttrid(resultSet.getInt("attrid"));
				result.add(FAT);
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
			}finally{
				try {
					CloseUtil.colseAll(preparedStatement, connection);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}
	

	@Override
	public List<TypeToattr> findTypeByAttrid(int attrid) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TypeToattr> result = new ArrayList<TypeToattr>();
		String sql = "select name from type where id = (";
		sql += "select attrid from typetoattr where ";
		if (attrid != 0) {
			sql += " attrid like '%" + attrid + "%'";
		}
		sql += ")";
		try {
			preparedStatement = connection.prepareStatement(sql);
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
		try {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TypeToattr FAT = new TypeToattr();
				FAT.setId(resultSet.getInt("id"));
				FAT.setTypeid(resultSet.getInt("typeid"));
				FAT.setAttrid(resultSet.getInt("attrid"));
				result.add(FAT);
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
			}finally{
				try {
					CloseUtil.colseAll(preparedStatement, connection);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public void saveTypeToattr(Type type, Attribute attribute) {
		TypeDao TD = new TypeDaoImpl();
		AttributeDao AD = new AttributeDaoImpl();
		try {
			TD.save(type);
			AD.save(attribute);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	

	@Override
	public void deleteTypeToattrBytypeid(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete typetoattr where typeid =";
		sql += id;
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
  


}
