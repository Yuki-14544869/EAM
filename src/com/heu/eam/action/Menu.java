package com.heu.eam.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Plan;
import com.heu.eam.exception.DaoException;
import com.heu.eam.filter.SessionCounter;
import com.heu.eam.service.PersonService;
import com.heu.eam.service.PlanService;
import com.heu.eam.service.impl.PersonServiceImpl;
import com.heu.eam.service.impl.PlanServiceImpl;

/**
 * Servlet implementation class Menu
 */

public class Menu extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PersonService ps = new PersonServiceImpl();
		Map<String, Object> msgMap=(Map<String, Object>) request.getSession().getAttribute("user");
		System.out.println(msgMap);
		
		if(msgMap==null){
			response.sendRedirect("InterFace/login/login.jsp");
		}else{
			Map<String, Map<String, String>> map=null;
			try {
				String id = (String) msgMap.get("id");
				String deptid=(String) msgMap.get("deptid");
				System.out.println(deptid);
				PlanService planService=new PlanServiceImpl();
				
				List<Map<String, Object>> backlog = planService.findByState(1, Integer.parseInt(deptid), Plan.class);
				List<Map<String, Object>> success = planService.findMyplan(2, Integer.parseInt(deptid), Plan.class);
				List<Map<String, Object>> defeat = planService.findMyplan(3, Integer.parseInt(deptid), Plan.class);
				
				request.setAttribute("backlog", backlog);
				request.setAttribute("success", success);
				request.setAttribute("defeat", defeat);
				String ip="unknow host";
				if(request.getHeader("x-forwarded-for")==null){
					ip=request.getRemoteAddr();
				}else{
					ip=request.getHeader("x-forwarded-for");
				}
				ip=ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
				map = ps.getIrp(id);
				request.setAttribute("irp", map);
				request.setAttribute("ip", ip);
				System.out.println(map);
				request.getRequestDispatcher("InterFace/IndexFrame/index.jsp").forward(
						request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
