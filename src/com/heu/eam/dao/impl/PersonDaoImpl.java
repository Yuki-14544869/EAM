package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.heu.eam.dao.PersonDao;
import com.heu.eam.dao.pojo.Person;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao {

	@Override
	public Map<String, Map<String, String>> getIrp(String id)
			throws DaoException {
		// TODO Auto-generated method stub
		// Map<String, List<String>> result = new HashMap<String,
		// List<String>>();
		Map<String, Map<String, String>> result = new LinkedHashMap<String, Map<String, String>>();

		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {

			String sql = "select c.code,c.pid,c.cname,c.path from persontorole a "
					+ "join roletoirp b on a.rid =b.roleid join irp c on b.irpid =c.id "
					+ "where a.pid = ? order by c.pid desc,c.seq";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String pid = resultSet.getString("pid");

				if (pid == null) {
					String myid = resultSet.getString("code");
					result.put(myid, new LinkedHashMap<String, String>());
					result.get(myid).put(resultSet.getString("cname"), null);
				} else {
					result.get(pid).put(resultSet.getString("cname"),
							resultSet.getString("path"));

				}
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

	@Override
	public Map<String, Object> textLogin(String userName, String password) throws DaoException {
		Map<String, Object> result = null;
		Connection connection =null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "select id,username,password,realName,sex,nat,borndate,hiredate,deptid,cardid,address,natpl,tel,mail,pos,state,del,createid,createtime,updateid,updatetime,version from person where username=? and password=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

		   if (resultSet.next()) {
			   result = new HashMap<String, Object>();
			   result.put("id", resultSet.getString("id"));
			   result.put("username", resultSet.getString("username"));
			   result.put("realname", resultSet.getString("realName"));
			   result.put("sex",resultSet.getString("sex"));
			   result.put("nat", resultSet.getString("nat"));
			   result.put("borndate", resultSet.getString("borndate"));
			   result.put("hiredate", resultSet.getString("hiredate"));
			   result.put("deptid", resultSet.getString("deptid"));
			   result.put("cardid", resultSet.getString("cardid"));
			   result.put("address", resultSet.getString("address"));
			   result.put("natpl", resultSet.getString("natpl"));
			   result.put("tel", resultSet.getString("tel"));
			   result.put("mail", resultSet.getString("mail"));
			   result.put("pos", resultSet.getString("pos"));
			   result.put("state", resultSet.getString("state"));
			   result.put("del", resultSet.getString("del"));
			   result.put("createId", resultSet.getString("createid"));
			   result.put("createtime", resultSet.getString("createtime"));
			   result.put("updateId", resultSet.getString("updateid"));
			   result.put("updatetime", resultSet.getString("updatetime"));
			   result.put("version", resultSet.getString("version"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("SQL异常",e);
		} catch (DaoException e) {
		} finally {
			CloseUtil.colseAll(preparedStatement, connection);
		}
		return result;
	}
}
