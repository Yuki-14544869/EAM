package com.heu.eam.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.dao.pojo.Place;
import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.dao.pojo.Test;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.BaseService;
import com.heu.eam.service.impl.BaseServiceImpl;

/**
 * Servlet implementation class ListItemAction
 */
@WebServlet("/suibian")
public class ListItemAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItemAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
			BaseService<Place> baseService=new BaseServiceImpl<Place>();
			List<Map<String, Object>> Place=null;
			List<Map<String, Object>> Dept=null;
			List<Map<String, Object>> Test=null;
			List<Map<String, Object>> Provider=null;
			List<Map<String, Object>> Type=null;
			
			
			try {
				Place = baseService.findAll(Place.class);
				Dept = baseService.findAll(Dept.class);
			    Test = baseService.findAll(Test.class);
				Provider = baseService.findAll(Provider.class);
				 Type = baseService.findAll(Type.class);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("Place", Place);
			request.setAttribute("Dept", Dept);
			request.setAttribute("Test", Test);
			request.setAttribute("provider", Provider);
			request.setAttribute("Type", Type);
			request.getRequestDispatcher("/InterFace/item/itemadd.jsp").forward(request, response);
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
