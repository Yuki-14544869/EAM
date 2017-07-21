package com.heu.eam.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import com.heu.eam.dao.pojo.Role;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.RoleService;
import com.heu.eam.service.impl.RoleServiceImpl;
import com.heu.eam.utils.DateUtil;
import com.heu.eam.utils.SessionUtil;

public class RoleAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Role role = new Role();
	private RoleService service = new RoleServiceImpl();
	
	

	public String FindRole(HttpServletRequest req, HttpServletResponse resp){
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String state = req.getParameter("state");
		List<Role> rr = service.findByElement(id,name,state);
		req.setAttribute("roles", rr);
		return "/InterFace/RoleFrame/role.jsp";
	}

	public String AddRole(HttpServletRequest req, HttpServletResponse resp) throws DaoException, IOException {
		String name = req.getParameter("name");
		
		String time = DateUtil.dateToString(new Date());
		if(name==""){
			role.setName(time);System.out.println("555");
		};
		if(name!=""){
			role.setName(name);
		};
		
		role.setState("0");
		String createid = SessionUtil.getId(req, resp);
		role.setCreateId(Integer.parseInt(createid));
		service.save(role);System.out.println("111");
		resp.sendRedirect( "RoleAction?method=FindRole");
		return null;
	}

	public String UpdateRole(HttpServletRequest req, HttpServletResponse resp) throws DaoException, ServiceBusinessException, IOException {
		//System.out.println("000");
		String id = req.getParameter("ChkName");
		//System.out.println(id);
		String name = req.getParameter("name");
		
		String time = DateUtil.dateToString(new Date());
		if(name==""){
			role.setName(time);
		};
		if(name!=""){
			role.setName(name);
		};
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", role.getName());
		Map<String,Object> m = service.findById(Integer.parseInt(id), Role.class);
		String object = (String) m.get("version");
		String createid = SessionUtil.getId(req, resp);
		service.update(map, createid, Role.class, object,id);
		resp.sendRedirect( "RoleAction?method=FindRole");
		return null;
	}

	public String Delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, DaoException {
		//System.out.println("666");
		String[] va=req.getParameterValues("ChkName");
		System.out.println("1"+va);
	    Integer[] ii=new Integer[va.length] ;
	    for(int i=0 ; i<va.length;i++){
			ii[i]=Integer.parseInt(va[i]);
		}
		System.out.println(ii[0]);
		String createid = SessionUtil.getId(req, resp);
		int updateid = Integer.parseInt(createid);
	    service.delete(ii, Role.class,updateid);
		resp.sendRedirect( "RoleAction?method=FindRole");
		return null;
	}
 
    public String Freeze(HttpServletRequest req,HttpServletResponse resp) throws DaoException, ServiceBusinessException, IOException{
    	System.out.println("666");
    	String id = req.getParameter("ChkName");
    	System.out.println(id);
    	Map<String, String> map = new HashMap<String, String>();
    	Map<String,Object> m = service.findById(Integer.parseInt(id), Role.class);
    	
    	int aa =Integer.parseInt((String)m.get("state")) ;
    	if( aa!=1 ){
    	map.put("state", "1");
    	}
    	if( aa==1 ){
    	map.put("state", "0");
    	}
		String object = (String) m.get("version");
		String createid = SessionUtil.getId(req, resp);
    	service.update(map, createid, Role.class, object,id);
    	resp.sendRedirect( "RoleAction?method=FindRole");
    	return null;
    }
}
