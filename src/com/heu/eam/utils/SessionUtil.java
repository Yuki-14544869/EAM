package com.heu.eam.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtil {

	@SuppressWarnings({ "unused", "unchecked" })
	public static  String getId(HttpServletRequest request,
			HttpServletResponse response)  {
		Map<String, String> map=(Map<String, String>) request.getSession().getAttribute("user");
		String id = map.get("id");
		return id;
		// TODO Auto-generated method stub
	
	}
	
	
}
