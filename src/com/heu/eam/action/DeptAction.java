package com.heu.eam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.DeptService;
import com.heu.eam.service.impl.DeptServiceImpl;
import com.heu.eam.utils.SessionUtil;
import com.sun.net.httpserver.HttpContext;

public class DeptAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	private Dept dept = new Dept();

	public String addDept(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, DaoException {

		String name = req.getParameter("name");
		String pid = req.getParameter("pid");
		String personid = req.getParameter("personid");
		dept.setName(name);
		dept.setPid(Integer.parseInt(pid));
		dept.setPersonid(Integer.parseInt(personid));
		String createid = SessionUtil.getId(req, resp);
		dept.setCreateId(Integer.parseInt(createid));

		System.out.println(createid);
		deptService.save(dept);

		resp.sendRedirect("/EAM/DeptAction?method=Find");
		return null;
	}

	public String delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException,
			DaoException {

		String[] va = req.getParameterValues("id");
		Integer[] ii = new Integer[va.length];
		for (int i = 0; i < va.length; i++) {
			ii[i] = Integer.parseInt(va[i]);
		}
		String createid = SessionUtil.getId(req, resp);
		System.out.println(createid);
		deptService.delete(ii, Dept.class, Integer.parseInt(createid));
		resp.sendRedirect("DeptAction?method=Find");
		return null;
	}

	/**
	 * 查询出所有部门
	 */
	public String Find(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pid = req.getParameter("pid");
		String personid = req.getParameter("personid");

		List<Dept> dd = deptService.findByElement(id, name, pid, personid);
		req.setAttribute("depts", dd);
		System.out.println("3333");
		return "/InterFace/Dept/dept.jsp";

	}

	public String update(HttpServletRequest req, HttpServletResponse resp)
			throws DaoException, ServiceBusinessException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		String name = req.getParameter("name");
		String pid = req.getParameter("pid");
		String personid = req.getParameter("personid");

		dept.setName(name);
		dept.setPid(Integer.parseInt(pid));
		dept.setPersonid(Integer.parseInt(personid));

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("pid", pid);
		map.put("personid", personid);

		Map<String, Object> m = deptService.findById(Integer.parseInt(id),
				Dept.class);
		String object = (String) m.get("version");
		String createid = SessionUtil.getId(req, resp);
		deptService.update(map, createid, Dept.class, object, id);
		resp.sendRedirect("DeptAction?method=Find");
		return null;
	}

	public String Jump(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, DaoException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pid = req.getParameter("pid");
		String personid = req.getParameter("personid");
		System.out.println("111");
		Map<String, Object> dept = deptService.findById(Integer.parseInt(id),
				Dept.class);
		req.setAttribute("dept", dept);
		return "/InterFace/Dept/updateDept.jsp";

	}

}
