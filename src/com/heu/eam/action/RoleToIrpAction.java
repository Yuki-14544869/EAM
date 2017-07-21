package com.heu.eam.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.p;

import com.heu.eam.service.RoleService;
import com.heu.eam.service.RoleToIrpService;
import com.heu.eam.service.impl.RoleServiceImpl;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.dao.pojo.Roletoirp;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.impl.RoleToIrpServiceImpl;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;

public class RoleToIrpAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int Count;
	private RoleToIrpService roleToIrpService =new RoleToIrpServiceImpl();
	public String findRoleToIrp(HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("name");
	    Map<String,List<String>> roletoirp=new HashMap<String, List<String>>();
		roletoirp= roleToIrpService.findAll(name);
		request.setAttribute("roletoirp", roletoirp);
//		try {
//			request.getRequestDispatcher("/EAM/PersonToRole.jsp").forward(request,response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "/InterFace/RoleToIrpFrame/FindByRole.jsp";
	}
	public String deleteRoleToIrp(HttpServletRequest request,HttpServletResponse response){
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String role = request.getParameter("name");
		System.out.println("delete;:;;;::;;;:;"+role);
		String irp_id = request.getParameter("select");
		System.out.println(irp_id);
		String idString="select role.id as r_id from role where role.name = '"+role+"'";
		//String sql="delete from persontorole where (select person.id from person where person.username = ')"+name+"') and ( select role.id from role where role.name = '"+role+"')";  
		System.out.println(idString);
		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(idString);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){	
				int r_id=resultSet.getInt("r_id");
				System.out.println("roleid是"+r_id+"  irpid是："+irp_id);
				String sql="delete from roletoirp where roleid = "+r_id+" and irpid = "+irp_id+" ";
				PreparedStatement perparedStatement2 = connection.prepareStatement(sql);
				int sss = perparedStatement2.executeUpdate();
				System.out.println("删除了："+sss+"个");
			}     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "/InterFace/RoleToIrpFrame/FindByRole.jsp";	
}
	public String jumpdeleteRoleToIrp(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		String selected = request.getParameter("selected");
          System.out.println(selected);
		List<Map<String, String>> roletoirp = new ArrayList<Map<String,String>>();
		roletoirp = roleToIrpService.deleteByRoleName(selected);
		request.setAttribute("deleteroletoirp", roletoirp);
		request.setAttribute("selected", selected);	
		return "/InterFace/RoleToIrpFrame/DeleteIrp.jsp";
	}
	public String jumpAddRoleToIrp(HttpServletRequest request,HttpServletResponse response)
	{  String name=request.getParameter("name");
	String selected=request.getParameter("selected");
	List<Map<String,String>> roletoirp=new ArrayList<Map<String,String>>();
	roletoirp=roleToIrpService.findName();
	System.out.println(roletoirp);
	request.setAttribute("addroletoirp", roletoirp);
	request.setAttribute("selected", selected);
	HttpSession session =request.getSession();
	session.setAttribute("addroletoirp", roletoirp);
	session.setAttribute("selected", selected);
		return "/InterFace/RoleToIrpFrame/AddRoleToIrp.jsp";
		
	}
	public String jumpRoleToIrp(HttpServletRequest request,HttpServletResponse response)
	{
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2=null;
		PreparedStatement preparedStatement3=null;
		int flag=1;
		int YN=1;
		int id=0;
		Connection connection = null;
		Map<String,String> myMap=new HashMap<String, String>();
		Count=(int)System.currentTimeMillis()%1000;
		String name=request.getParameter("name");System.out.println(name);
		String cid=request.getParameter("select");System.out.println(cid);
		int cid1=Integer.parseInt(cid);
		String sql1="select id from Role where name='"+name+"'";
				try {
					connection=DBUtil.getConnection();
					preparedStatement3=connection.prepareStatement(sql1);
					ResultSet resultSet=preparedStatement3.executeQuery();
					while(resultSet.next()){
						id=resultSet.getInt("id");}
						System.out.println("id=%d");
						System.out.println(id);
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				myMap.put(String.valueOf(id), cid);
				System.out.println(myMap);
				System.out.println("\n\n\n\n");
				String sql2="select roleid,irpid from roletoirp where 1=1";
				System.out.println(sql2);
				try {
					preparedStatement2=connection.prepareStatement(sql2);
					ResultSet resultSet1=preparedStatement2.executeQuery();
				while(resultSet1.next()){
					Map<String, String> aMap=new HashMap<String, String>();
					String id2=String.valueOf(resultSet1.getInt("roleid"));
					String id3=String.valueOf(resultSet1.getInt("irpid"));
					aMap.put(id2, id3);
					System.out.println(aMap);
				if(aMap.equals(myMap)){
					flag=0;
					
					System.out.println("stop");
				}
				}
				System.out.println(flag);
				if(flag==0){
					request.setAttribute("YN", 0);
					return "/InterFace/RoleToIrpFrame/AddRoleToIrp.jsp";
				}
				else {
					request.setAttribute("YN", 1);		
					String sql="insert into roletoirp(id,roleid,irpid) values("+Count+",(select role.id from role where role.name = '"
				+ name + "'),"+cid1+")";
		System.out.println(sql);
			try {
				preparedStatement = connection.prepareStatement(sql);
				int sss=preparedStatement.executeUpdate();
			System.out.println(sss+"111111111111111111111111111111111");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				try {
					try {
						preparedStatement2.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						preparedStatement3.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					CloseUtil.colseAll(preparedStatement, connection);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
		return "/InterFace/RoleToIrpFrame/FindByRole.jsp";	}}