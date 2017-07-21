package com.heu.eam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.heu.eam.dao.DeptDao;
import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;
public class DeptDaoImpl extends BaseDaoImpl<Dept> implements DeptDao{

	@Override
	public List<Dept> findDeptByCondition(int id, String name)  {
		List<Dept> deptList = new ArrayList<Dept>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select id,name,pid,personid,tel from dept,person where 1=1");
		try {
			connection = DBUtil.getConnection();
			
			if(id>0){
				sql.append(" and id=?");
				
			}
			if(name!=null&&!"".equals("")){
				sql.append(" and name=?");
			}
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Dept dept =new Dept();
				deptList.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deptList;
	}

	@Override
	public List<Dept> findDeptByName(String name) {
		List<Dept> deptList = new ArrayList<Dept>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		StringBuffer sql = new StringBuffer();
		//sql.append("select id,name,pid,personid,tel from dept,person where 1=1");
		sql.append("select id,name from dept where name = '" + name+"'");
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				//Dept dept =new Dept(rs.getInt("id"), rs.getString("name"), rs.getInt("pid"), rs.getInt("personid"), rs.getString("tel"));
				Dept dept = new Dept();
				dept.setId(rs.getInt("id"));
				dept.setName(rs.getString("name"));
				deptList.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deptList;
	}

	/**
	 * 添加部门
	 */
	@Override
	public int addDept(Dept dept) {
		int i = 0;
		try {
			this.save(dept);
			i = 1;
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
		return i;
	}


	@Override
	public int deleteDeptById(int id) {
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "delete from dept where id =?";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			 i = preparedStatement.executeUpdate();
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
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
	public int updateDept(Dept dept) {
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "update dept set name=?,pid=?,personid=? where id=?";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dept.getName());
			preparedStatement.setInt(2, dept.getPid());
			preparedStatement.setInt(3, dept.getPersonid());
			i = preparedStatement.executeUpdate();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}finally {
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
	public List<Dept> findChildDept(int pid) {
		List<Dept> childDeptList = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "select id,name,pid,personid,tel from dept,person where pid=?";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setInt(1, pid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Dept dept =new Dept();
				childDeptList.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return childDeptList;
	}

	@Override
	public Dept findByName(String name) {
		List<Dept> childDeptList = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "select id,name,pid,personid,tel from dept,person where name=?";
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Dept dept =new Dept();
				childDeptList.add(dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return childDeptList.get(0);
	}

	@Override
	public List<Dept> findByElement(String id, String name, String pid,
			String personid) {
		Connection connection= null;
		try {
			connection = DBUtil.getConnection();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		List<Dept> result = new ArrayList<Dept>();
		String sql ="select id,name,pid,personid  from dept where 1=1 and del=0 ";
		if(id!=null && id.length()>0){
			sql+= " and id like '%"+id+"%'";
		}
		if(name!=null && name.length()>0){
			sql+=" and name like '%"+name+"%'";
		}
		if(pid!=null && pid.length()>0){
			sql+= "  and pid='"+pid+"'";
		}
		if(personid!=null && personid.length()>0){
			sql+= "  and personid='"+personid+"'";
		}
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(sql);
			while(resultSet.next()){
				Dept row=new Dept();
				row.setId(resultSet.getInt("id"));
				row.setName(resultSet.getString("name"));
				row.setPid( Integer.parseInt( resultSet.getString("Pid")));
				row.setPersonid( Integer.parseInt( resultSet.getString("Personid")));
				
				result.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
