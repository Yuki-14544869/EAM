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

import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;
import com.heu.eam.dao.RoletoirpDao;
import com.heu.eam.dao.pojo.PersonToRole;
import com.heu.eam.dao.pojo.Roletoirp;

public class RoletoirpDaoImpl extends BaseDaoImpl<Roletoirp> implements
		RoletoirpDao {
	@Override
	public Map<String,List<String>> find(String name) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2= null;
		Connection connection = null;
		Roletoirp roletoirp=new Roletoirp();
		try{connection=DBUtil.getConnection();		
			String sql1 = null;
			String sql2 =null;
			List<String> none=new ArrayList<String>();
			sql2="select a.name, c.cname from Role a left join roletoirp b on a.id = b.roleid left join Irp c on b.irpid = c.id where a.del='0' and a.name like '%"+name+"%'";
			preparedStatement2=connection.prepareStatement(sql2);
			ResultSet resultSet=preparedStatement2.executeQuery();
			//while (resultSet1.next()) {
			//	String rolename=resultSet1.getString("role_name");
				//map.put(rolename,none);
			//}
			//sql1="select Role.name as role_name,Irp.cname as irp_name from Role left join roletoirp on role.id = roletoirp.roleid left join Irp on roletoirp.irpid = irp.id where role.name like '%"+name+"%' group by role.name";
			//sql1="select test2.username as test2_username,test3.name as test3_name from test2 join test1 on test2.id = test1.pid join test3 on test1.rid = test3.id where test2.username='"+name+"'";
			//sql1="select test2.username as test2_username,test3.name as test3_name from test2 join test1 on test2.id = test1.pid join test3 on test1.rid = test3.id where test2.username like '%"+name+"%'";
			System.out.println(sql2);
			//preparedStatement=connection.prepareStatement(sql1);
			//ResultSet resultSet = preparedStatement.executeQuery();
			//System.out.println(map);
		    while(resultSet.next())
		    {
		    	String pid=resultSet.getString("name");
		    	String rid=resultSet.getString("cname");
//		    	personToRole.setPid(Integer.valueOf(pid));
//		    	personToRole.setRid(Integer.valueOf(rid));
//		    	personToRole.setDel("0");
//		    	personToRole.setId(count++);
		    	System.out.println(rid);
		    	if (map.containsKey(pid))
					map.get(pid).add(rid);
				else {
					List<String> list2 = new ArrayList<String>();
					list2.add(rid);
					map.put(pid, list2);
				}
		    	
		    	//list.add(personToRole);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		System.out.println(map);
		return map;
		
		
		
	}
	@Override
	public List<Map<String,String>> deleteByRoleName(String name) {
		// TODO Auto-generated method stub
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
			if(connection!=null)System.out.println("yyyyyyyyyyyyy22222222222");
			else System.out.println("nnnnnnn3333333");
			String sql1 = null;
			System.out.println(name);
			sql1="select a.cname, a.id from roletoirp c join role b on b.id=c.roleid join irp a on c.irpid = a.id where b.name='"+name+"'";
			System.out.println(sql1);
			preparedStatement = connection.prepareStatement(sql1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Map<String,String> mymap= new HashMap<String, String>();
				String cname = resultSet.getString("cname");
				int id=resultSet.getInt("id");
				String id1=String.valueOf(id);
				mymap.put("id", id1);
				mymap.put("cname", cname);
				System.out.println(mymap);
				list.add(mymap);
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

	@Override
	public List<Map<String,String>> findName() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		String sql = "select id,cname from irp";
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Map<String, String> mymap = new HashMap<String, String>();
				String cname = resultSet.getString("cname");
				String id=resultSet.getString("id");
				mymap.put("id",id);
				mymap.put("name", cname);
				System.out.println(mymap);
				result.add(mymap);
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
			}
		}
		return result;

	}
}
