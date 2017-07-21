package com.heu.eam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.Count;

import sun.security.krb5.internal.PAEncTSEnc;

import com.heu.eam.dao.RoleDao;
import com.heu.eam.dao.impl.RoleDaoImpl;
import com.heu.eam.dao.pojo.PersonToRole;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.PersonToRoleService;
import com.heu.eam.service.impl.PersonToRoleServiceImpl;
import com.heu.eam.utils.CloseUtil;
import com.heu.eam.utils.DBUtil;
import com.sun.org.apache.xpath.internal.operations.And;

public class PersonToRoleAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	RoleDao roledao = new RoleDaoImpl();
	private static int Count;
	@SuppressWarnings("unused")
	public PersonToRole personToRole = new PersonToRole();
	private Integer[] ii;

	private PersonToRoleService personToRoleService = new PersonToRoleServiceImpl();

	@SuppressWarnings("null")
	public String deletePersonToRole(HttpServletRequest request,
			HttpServletResponse response) {

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		String name = request.getParameter("name");
		System.out.println("delete;:;;;::;;;:;" + name);
		String role = request.getParameter("select");
		System.out.println(role);
		String idString = "select person.id as p_id,role.id as r_id  from role,person where role.name = '"
				+ role + "' and person.username = '" + name + "'";
		// String
		// sql="delete from persontorole where (select person.id from person where person.username = ')"+name+"') and ( select role.id from role where role.name = '"+role+"')";
		System.out.println(idString);
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(idString);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				int p_id = resultSet.getInt("p_id");
				int r_id = resultSet.getInt("r_id");
				System.out.println("pid是" + p_id + "  rid是：" + r_id);
				String sql = "delete from persontorole where rid = " + r_id
						+ " and pid = " + p_id + " ";
				PreparedStatement perparedStatement2 = connection
						.prepareStatement(sql);
				int sss = perparedStatement2.executeUpdate();
				System.out.println("删除了：" + sss + "个");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			CloseUtil.colseAll(preparedStatement, connection);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/InterFace/PersonToRole/PersonToRole.jsp";

	}

	public String addPersonToRole(HttpServletRequest request,
			HttpServletResponse response) {

		return "/InterFace/PersonToRole/PersonToRole.jsp";
	}

	public String jumpAddPersonToRole(HttpServletRequest request,
			HttpServletResponse response) {
		// String name = request.getParameter("name");
		String selected = request.getParameter("selected");
		List<String> persontorole = new ArrayList<String>();
		persontorole = personToRoleService.findName();
		// System.out.println("name 是 :"+name);
		request.setAttribute("addpersontorole", persontorole);
		request.setAttribute("selected", selected);
		
		HttpSession session = request.getSession();
		session.setAttribute("addpersontorole",persontorole);
		session.setAttribute("selected", selected);
		
		System.out.println("select 是: " + selected);
		return "/InterFace/PersonToRole/AddPersonToRole.jsp";

	}

	public String jumpDeletePersonToRole(HttpServletRequest request,
			HttpServletResponse response) {

		String name = request.getParameter("name");
		String selected = request.getParameter("selected");
		System.out.println(selected);
		List<String> persontorole = new ArrayList<String>();
		persontorole = personToRoleService.deleteByRoleName(selected);
		for (String s : persontorole) {
			System.out.println(s);
		}
		request.setAttribute("deletepersontorole", persontorole);
		request.setAttribute("selected", selected);

		return "/InterFace/PersonToRole/DeletePersonToRole.jsp";
	}

	@SuppressWarnings("null")
	public String jumpPersonToRole(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		Count = (int) System.currentTimeMillis() % 1000;
		String name = request.getParameter("name");
		System.out.println(name);
		String role = request.getParameter("select");
		System.out.println(role);
		Map<String, List<String>> persontorole = new HashMap<String, List<String>>();
		persontorole = personToRoleService.findall(name);
		//persontorole.put("mess", null);
		System.out.println(persontorole);
		if (persontorole.get(name).contains(role)) {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			//response.getWriter().print("<script type='text/javascript'>alert(\' no\');</script>");
			request.setAttribute("ishad", 1);
//			printwriter out = response.getwriter();
//			out.print("<script>alert(\'ok\');</script>");
//			System.out.println("out============"+out.toString());
			// request.setAttribute("ishad", 1);
			return "/InterFace/PersonToRole/AddPersonToRole.jsp";

		} else {
			request.setAttribute("ishad", 0);
			String sql = "insert into persontorole(id,pid,rid) values("
					+ Count
					+ ",(select person.id from person where person.username = '"
					+ name + "'),(select role.id from role where role.name = '"
					+ role + "'))";
			System.out.println(sql);
			try {
				connection = DBUtil.getConnection();
				preparedStatement = connection.prepareStatement(sql);
				int sss = preparedStatement.executeUpdate();
				System.out.println(sss + "111111111111111111111111111111111");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				CloseUtil.colseAll(preparedStatement, connection);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "/InterFace/PersonToRole/PersonToRole.jsp";
		}
	}

	public String findPersonToRole(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("name");

		Map<String, List<String>> persontorole = new HashMap<String, List<String>>();
		persontorole = personToRoleService.findall(name);
		request.setAttribute("persontorole", persontorole);
		// try {
		// request.getRequestDispatcher("/EAM/PersonToRole.jsp").forward(request,response);
		// } catch (ServletException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return "/InterFace/PersonToRole/PersonToRole.jsp";

	}

}
