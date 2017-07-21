package com.heu.eam.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Attribute;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.dao.pojo.TypeToattr;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.TypeService;
import com.heu.eam.service.TypeToattrService;
import com.heu.eam.service.impl.TestServiceImpl;
import com.heu.eam.service.impl.TypeServiceImpl;
import com.heu.eam.service.impl.TypeToattrServiceImpl;

public class TypeToattrAction extends BaseAction {

	private TypeToattrService typeToattrService = new TypeToattrServiceImpl();

	public String addTypeToAttr(HttpServletRequest request,
			HttpServletResponse response) {

		return null;
	}

	public String deleteTypeToAttr(HttpServletRequest request,
			HttpServletResponse response) {

		return null;
	}

	public String updateTypeToAttr(HttpServletRequest request,
			HttpServletResponse response) {

		return null;
	}
}
