package com.heu.eam.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.AttributeService;
import com.heu.eam.service.BaseService;
import com.heu.eam.service.impl.AttributeServiceImpl;
import com.heu.eam.service.impl.BaseServiceImpl;
import com.heu.eam.utils.CloseUtil;


@SuppressWarnings("serial")
public class AttributeAction extends BaseAction{
	public String addAttribute(HttpServletRequest request, HttpServletResponse response) {
		AttributeService attributeService=new AttributeServiceImpl();
		 String id=request.getParameter("id");
	     String name=request.getParameter("name");
	     String detail=request.getParameter("detail");
	     Attribute temp=new Attribute(Integer.parseInt(id), name, detail);
		 try {
			attributeService.save(temp);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		return null;
	}
	public String deleteAttribute(HttpServletRequest request, HttpServletResponse response) {
		AttributeService attributeService=new AttributeServiceImpl();
		String[] ids=request.getParameterValues("selected");	
		Integer[] T=new Integer[60];
		int i=0;
		for(String id:ids){
			T[i++]=Integer.parseInt(id);
		}
		try {
			attributeService.delete(T, Attribute.class, Integer.parseInt(String.valueOf(request.getSession().getAttribute("detail"))));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String updateAttribute(HttpServletRequest request,HttpServletResponse response) {
	
	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String detail = request.getParameter("detail");
	String attribute = (String) request.getSession().getAttribute("userid");
	
	BaseService<Attribute> baseService =new BaseServiceImpl<Attribute>();
	
	Map<String,String> temp=new HashMap<String,String>();
	temp.put("id",id);
	temp.put("name", name);
	temp.put("detail",detail);
	
	try {
		baseService.update(temp, id , Attribute.class, "1", attribute);
	} catch (DaoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServiceBusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return null;
	}
	public String findAttribute(HttpServletRequest request,
			HttpServletResponse response) {
		AttributeService attributeService=new AttributeServiceImpl();
		String name=request.getParameter("name");
		List<Attribute> result = null;
		try {
			result = attributeService.findAttributeByName(name);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("attribute", result);
		return null;
	}
	
	public String findAttributetwo(HttpServletRequest request,
			HttpServletResponse response) {
		AttributeService attributeService=new AttributeServiceImpl();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		List<Attribute> result = null;
		try {
			result = attributeService.findAttributeByCondition(id, name);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("attributeed", result);
		return null;
	}

	public String findAllAttribute(HttpServletRequest request,
		HttpServletResponse response){
	AttributeService attributeService=new AttributeServiceImpl();
	List<Map<String, Object>> coloums=null;
	try {
		coloums = attributeService.findAll(Attribute.class);
	} catch (DaoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("attributes", coloums);
	
	return null;
	
}
}
