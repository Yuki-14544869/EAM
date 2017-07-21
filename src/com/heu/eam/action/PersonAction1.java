package com.heu.eam.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Irp;
import com.heu.eam.dao.pojo.Person;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.IrpService;
import com.heu.eam.service.PersonService;
import com.heu.eam.service.impl.IrpServiceImpl;
import com.heu.eam.service.impl.PersonServiceImpl;

public class PersonAction1 extends BaseAction{
		private static final long serialVersionUID = 1L;
		private PersonService personService = new PersonServiceImpl();
		public String findAll(HttpServletRequest request,//查询全部菜单
				HttpServletResponse response){
			
			List<Map<String, Object>> rs=null;			
			try {
				    rs=personService.findAll(Person.class);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Map<String, Object> map = rs.get(0);
			request.setAttribute("rs", rs);
			return "/InterFace/PersonFrame/selectPerson.jsp";		
    }
}