package com.heu.eam.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Type;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.TypeService;
import com.heu.eam.service.impl.TypeServiceImpl;
import com.heu.eam.utils.SessionUtil;

public class TypeAction extends BaseAction {
	private TypeService typeService = new TypeServiceImpl();

	public String addType(HttpServletRequest request,
			HttpServletResponse response) throws DaoException {
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		Type type = new Type();
		type.setCreateId(Integer.parseInt(SessionUtil.getId(request, response)));
		type.setName(name);
		type.setDetail(detail);
		type.setDel("0");
		typeService.save(type);
		List<Map<String, Object>> resultList = typeService.findAll(Type.class);
		request.setAttribute("types", resultList);
		return "/InterFace/Type/mainTypeToattr.jsp";
	}

	public String jumpToAddType(HttpServletRequest request,
			HttpServletResponse response) throws DaoException {

		return "/InterFace/Type/addType.jsp";
	}

	public String deleteType(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException,
			DaoException {
		String idString = request.getParameter("id");
		typeService.delete(new Integer[] { Integer.parseInt(idString) },
				Type.class,
				Integer.parseInt(SessionUtil.getId(request, response)));
		List<Type> result = typeService.findTypeByName(null);
		request.setAttribute("types", result);
		return "/InterFace/Type/mainTypeToattr.jsp";

	}

	public String jumpToUpdateType(HttpServletRequest request,
			HttpServletResponse response) throws NumberFormatException,
			DaoException {
		String idString = request.getParameter("id");
		Map<String, Object> resultMap = typeService.findById(
				Integer.parseInt(idString), Type.class);
		request.setAttribute("type", resultMap);
		return "/InterFace/Type/updateType.jsp";
	}

	public String findType(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter("name");
		List<Type> result = typeService.findTypeByName(name);
		request.setAttribute("types", result);
		return "/InterFace/Type/mainTypeToattr.jsp";
	}

	public String updateType(HttpServletRequest request,
			HttpServletResponse response) throws DaoException,
			ServiceBusinessException {
		System.out.println("aaaaa");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String version = request.getParameter("version");
		Map<String, String> updateMap = new HashMap<>();
		updateMap.put("name", name);
		updateMap.put("detail", detail);
		typeService.update(updateMap, SessionUtil.getId(request, response),
				Type.class, version, id);
		List<Map<String, Object>> resultList = typeService.findAll(Type.class);
		request.setAttribute("types", resultList);
		return "/InterFace/Type/mainTypeToattr.jsp";
	}

}