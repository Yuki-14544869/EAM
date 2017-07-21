package com.heu.eam.dao.impl;

import java.beans.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;

import com.heu.eam.dao.PersonToRoleDao;
import com.heu.eam.dao.pojo.PersonToRole;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

;

public class PersonToRoleDaoImpl extends BaseDaoImpl<PersonToRole> implements
		PersonToRoleDao {

	@Override
	public Map<String, List<String>> find(String name) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		PersonToRole personToRole = new PersonToRole();
		try {
			connection = DBUtil.getConnection();

			String sql1 = null;
			//sql1="select a.username, c.name from person a left join persontorole b on a.id = b.pid left join role c on b.rid = c.id where a.username like '%"+name+"%' group by a.username,c.name";
			sql1="select a.username, c.name from person a left join persontorole b on a.id = b.pid left join role c on b.rid = c.id where a.username like '%"+name+"%' group by a.username,c.name";
			//sql1 = "select person.username as per_name,role.name as ro_name from person join persontorole on person.id = persontorole.pid join role on persontorole.rid = role.id where person.username like '%"
				//	+ name + "%'";
			// sql1="select test2.username as test2_username,test3.name as test3_name from test2 join test1 on test2.id = test1.pid join test3 on test1.rid = test3.id where test2.username='"+name+"'";
			// sql1="select test2.username as test2_username,test3.name as test3_name from test2 join test1 on test2.id = test1.pid join test3 on test1.rid = test3.id where test2.username like '%"+name+"%'";
			System.out.println(sql1);
			preparedStatement = connection.prepareStatement(sql1);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
//				String pid = resultSet.getString("per_name");
//				String rid = resultSet.getString("ro_name");
				String pid=resultSet.getString("username");
				String rid=resultSet.getString("name");
				//String p_zid=resultSet.getString("id");
				// personToRole.setPid(Integer.valueOf(pid));
				// personToRole.setRid(Integer.valueOf(rid));
				// personToRole.setDel("0");
				// personToRole.setId(count++);
				//System.out.println("----------------------------");
				//System.out.println(p_zid);
				System.out.println("-----------------------");
				System.out.println(rid);
				System.out.println("-----------------------");
				if (map.containsKey(pid))
					map.get(pid).add(rid);
				else {
					List<String> list2 = new ArrayList<String>();
					list2.add(rid);
					map.put(pid, list2);
				}
				// list.add(personToRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
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
		return map;

	}

	@Override
	public int deletePersonToRoleId(int id) {
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "delete from dept where id =?";
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement(sql);

			i = preparedStatement.executeUpdate();

			preparedStatement.setInt(1, id);
			i = preparedStatement.executeUpdate();

		} catch (DaoException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return i;
	}

	@Override
	public List<String> findName() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		List<String> result = new ArrayList<String>();
		String sql = "select name from role ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				System.out.println(name);
				result.add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			CloseUtil.colseAll(preparedStatement, connection);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

	}

	public List<String> deleteByRoleName(String name) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			if(connection!=null)System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyy22222222222222222222222");
			else System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn33333333333333333333");
			String sql1 = null;
			System.out.println(name);
			sql1 = "select role.name as ro_name  from person join persontorole on person.id = persontorole.pid join role on persontorole.rid = role.id where person.username = '"+ name + "'";
			System.out.println(sql1);
			preparedStatement = connection.prepareStatement(sql1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String rid = resultSet.getString("ro_name");
				list.add(rid);
				System.out.print(rid+".....");
			}
			
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DaoException e) {
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
				return list;
		
	
		
	}

}

