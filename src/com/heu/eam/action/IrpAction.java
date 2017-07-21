package com.heu.eam.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Irp;
import com.heu.eam.dao.pojo.Place;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.IrpService;
import com.heu.eam.service.impl.IrpServiceImpl;
import com.heu.eam.utils.SessionUtil;




public class IrpAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Irp irp = new Irp();
	private IrpService irpService = new IrpServiceImpl();
	
	//增加
	public String addIrp(HttpServletRequest request,
			HttpServletResponse response) throws DaoException, IOException {
		

		String path = request.getParameter("path");
		String name = request.getParameter("name");
		String pid = request.getParameter("pid");
		String cname = request.getParameter("cname");
		String detal = request.getParameter("detal");
		String code = request.getParameter("code");

		
		

		irp.setPath(path);
		irp.setName(name);
		irp.setCname(cname);
		irp.setPid(Integer.parseInt(pid));
		irp.setDetal(detal);
		irp.setDel("0"); 
		irp.setCode(Integer.parseInt(code));
		irp.setCreateId(Integer.parseInt(SessionUtil.getId(request, response))); 
		//irp.setCreateId(1); 
		irp.setState(request.getParameter("del"));

		irpService.save(irp);
		response.sendRedirect( "IrpAction?method=findAll");
		//return "/InterFace/IRP/select.jsp";
		return null;
	}
	   
	//删除
	public String deleteIrp (HttpServletRequest request,
			HttpServletResponse response) throws IOException, DaoException {
		String[] va = request.getParameterValues("box");
		System.out.println("1"+va);
	    Integer[] ii = new Integer[va.length] ;
	    for(int i=0 ; i<va.length;i++){
			ii[i]=Integer.parseInt(va[i]);
		}
		System.out.println(ii[0]);
		String createid = SessionUtil.getId(request, response);
		int updateid = Integer.parseInt(createid);
		irpService.delete(ii, Irp.class,updateid);
		response.sendRedirect( "IrpAction?method=findAll");
		return null;
	}
	
	//更新
	public String updateIrp(HttpServletRequest req,
			HttpServletResponse resp) throws NumberFormatException, DaoException, IOException {	
		String id = req.getParameter("id");
		String path = req.getParameter("path");
		String name = req.getParameter("name");
		String pid = req.getParameter("pid");
		String cname = req.getParameter("cname");
		String detal = req.getParameter("detal");
		String code = req.getParameter("code");
		String state = req.getParameter("state");
		String version = req.getParameter("version");
		String createid = SessionUtil.getId(req, resp);
		
		
		
		//irp.setId(Integer.parseInt(id));
		irp.setPath(path);
		irp.setName(name);
		irp.setPid(Integer.parseInt(pid));
		irp.setCname(cname);
		irp.setDetal(detal);
		irp.setCode(Integer.parseInt(code));
		irp.setState(state);
		//irp.setVersion(Integer.parseInt(version));
		Map<String,String> m=new HashMap<String,String>();
        
        //Map<String,Object> mm = irpService.findById(Integer.parseInt(id), Test.class);
		//String object = (String) mm.get("version");
        //String object = "1";
        
        //m.put("name", id);
        m.put("path", path);
        m.put("name",name);
        m.put("pid", pid);
        m.put("cname", cname);
        m.put("detal", detal);
        m.put("code", code);
        m.put("state", state);

       try {
		irpService.update(m, createid, Irp.class,version,id);
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (DaoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServiceBusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
       resp.sendRedirect( "IrpAction?method=findAll");
       return null;
	}
	
	
	public String findAll(HttpServletRequest request,//查询全部菜单
			HttpServletResponse response){
		
		IrpService irpservice=new IrpServiceImpl();
		List<Map<String, Object>> rs=null;
		try {
			    rs=irpservice.findAll(Irp.class);
		} catch (DaoException e) {
		
			e.printStackTrace();
		}
		request.setAttribute("irp", rs);
		
		return "/InterFace/IRP/select.jsp";
	}
	
	public String findByName(HttpServletRequest request,
			HttpServletResponse response) {
		IrpService irpservice = new IrpServiceImpl();		
		Map<String,String> map = new HashMap<String, String>();
		List<Map<String, Object>> s =null;
		String cname = request.getParameter("nme");
		
		System.out.println("cname : " + cname);
		try {
			s = irpservice.findBy(map, Irp.class);
			System.out.println(s);

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("irp", s);
		return "/InterFace/IRP/select.jsp";
	}

	@SuppressWarnings("rawtypes")
	public String findByDel(HttpServletRequest request,HttpServletResponse response){
    	IrpService irpservice=new IrpServiceImpl();
    	List<Map> rs = new ArrayList<Map>();
		Map<String, Object> s = new HashMap<String, Object>();
		int code =  Integer.parseInt("code");
    	try {
    		
			s = irpservice.findByPid(code);
			s.put("CCC", s.get("CCC"));
			System.out.println(s);
		    rs.add(s); 	
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	request.setAttribute("irp", rs);
		return "/InterFace/IRP/select.jsp";
    }
	
    public String irpFreeze(HttpServletRequest request,HttpServletResponse response) throws DaoException, ServiceBusinessException, IOException{
    	System.out.println("666");
    	String id = request.getParameter("box");
    	System.out.println(id);
    	Map<String, String> map = new HashMap<String, String>();
    	Map<String,Object> m = irpService.findById(Integer.parseInt(id), Irp.class);
    	
    	int aa =Integer.parseInt((String)m.get("state")) ;
    	if( aa!=1 ){
    	map.put("state", "1");
    	}
    	if( aa==1 ){
    	map.put("state", "0");
    	}
		String object = (String) m.get("version");
		String createid = SessionUtil.getId(request, response);
		irpService.update(map, createid, Irp.class, object,id);
    	response.sendRedirect( "IrpAction?method=findAll");
    	return null;
    }
    
    public String findById(HttpServletRequest request,//查询全部菜单
			HttpServletResponse response) throws IOException{
		
		IrpService irpservice=new IrpServiceImpl();
		String cname = request.getParameter("nme");
		Map<String,String> map = new HashMap<String, String>();
		map.put("cname", cname);
		List<Map<String, Object>> result = null;
		try {
			result = irpservice.findBy(map,Place.class);
		} catch (DaoException e) {
		
			e.printStackTrace();
		}
		request.setAttribute("irp", result);
		response.sendRedirect( "IrpAction?method=findAll");
		return "/InterFace/IRP/select.jsp";
	}
    
    public String SearchIrp(HttpServletRequest request, HttpServletResponse response) 
    		throws DaoException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	Map<String, Object> result = irpService.findById(id, Irp.class);
    	request.setAttribute("irp", result);
    	return "/InterFace/IRP/edit.jsp";
    }
    
    public String returnIrp(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	System.out.println("returnirp is running");
    	response.sendRedirect( "IrpAction?method=findAll");
    	return null;
    }
    
    public String deleteonly(HttpServletRequest request, HttpServletResponse response) throws IOException, DaoException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	System.out.println(id);
    	Integer[] ii = new Integer[1] ;
    	ii[0] = id;
    	String createid = SessionUtil.getId(request, response);
		int updateid = Integer.parseInt(createid);
		irpService.delete(ii, Irp.class,updateid);
    	response.sendRedirect( "IrpAction?method=findAll");
    	return null;
    }
    
}
