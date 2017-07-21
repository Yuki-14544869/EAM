package com.heu.eam.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.DBUtil;

public class DBConfigListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		InputStream input = context.getResourceAsStream("/WEB-INF/config/db.xml");
		try {
			DBUtil.init(input);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
