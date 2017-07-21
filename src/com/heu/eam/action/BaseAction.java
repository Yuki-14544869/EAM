package com.heu.eam.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用的servlet
 */
public class BaseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			// 1.获取子类
			@SuppressWarnings("rawtypes")
			Class clazz = this.getClass();
			// 2.获取请求方法
			String m = request.getParameter("method");
			if (m == null) {
				m = "index";
			}
			// 3.获取方法对象
			Method method;
			try {
				method = clazz.getMethod(m, HttpServletRequest.class,
						HttpServletResponse.class);
				// 4.方法执行
				String s = (String) method.invoke(this, request, response);
				
				if (s != null) {
					request.getRequestDispatcher(s).forward(request, response);
				}
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public String index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}

}
