package com.heu.eam.action;


import java.util.HashMap;
import java.util.List;




import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import com.heu.eam.dao.pojo.Role;
import com.heu.eam.dao.pojo.Test;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.TestService;
import com.heu.eam.service.impl.TestServiceImpl;
import com.heu.eam.utils.SessionUtil;

public class TestAction extends BaseAction{
	
	private TestService service= new TestServiceImpl();
	private Test test = new Test();
	private TestService testService = new TestServiceImpl();
	
	public String AddTest(HttpServletRequest req, HttpServletResponse resp) throws DaoException {
		
		String name = req.getParameter("name");
		String unit = req.getParameter("unit");
		String count = req.getParameter("count");
		String proddate = req.getParameter("proddate");
		String recvdate = req.getParameter("recvdate");
		String testdate = req.getParameter("testdate");
		String provid = req.getParameter("provid");
		String person = req.getParameter("person");
		String project = req.getParameter("project");
		String conclusion = req.getParameter("conclusion");
		String detail = req.getParameter("detail");
		String testcode = req.getParameter("testcode");
		
		String createId = req.getParameter("createId");
		String createtime = req.getParameter("createtime");
		
		
		test.setName(name);
		test.setUnit(unit);
		test.setCount(count);
		test.setProddate(proddate);
		test.setRecvdate(recvdate);
		test.setTestdate(testdate);
		test.setProvid(provid);
		test.setPerson(person);
		test.setProject(project);
		test.setConclusion(conclusion);
		test.setTestcode(testcode);
		test.setDetail(detail);
		test.setDel("0"); 
		test.setCreateId(Integer.parseInt(SessionUtil.getId(req, resp))); 
		test.setCreatetime(createtime); 
		System.out.println(conclusion );
		
		testService.save(test);
	    
		return "/InterFace/TestFrame/Testindex.jsp";
	}
	
	public String UpdateTest(HttpServletRequest req, HttpServletResponse resp)throws DaoException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String unit = req.getParameter("unit");
		String count = req.getParameter("count");
		String proddate = req.getParameter("proddate");
		String recvdate = req.getParameter("recvdate");
		String testdate = req.getParameter("testdate");
		String testcode = req.getParameter("testcode");
		String provid = req.getParameter("provid");
		String person = req.getParameter("person");
		String project = req.getParameter("project");
		String conclusion = req.getParameter("conclusion");
		String detail = req.getParameter("detail");
		String createid = SessionUtil.getId(req, resp);
		
		
		
		test.setName(name);
		test.setUnit(unit);
		test.setCount(count);
		test.setProddate(proddate);
		test.setRecvdate(recvdate);
		test.setTestdate(testdate);
		test.setProvid(provid);
		test.setPerson(person);
		test.setProject(project);
		test.setTestcode(testcode);
		test.setConclusion(conclusion);
		test.setDetail(detail);
		String updateid=SessionUtil.getId(req, resp);
        Map<String,String> m=new HashMap<String,String>();
        
        Map<String,Object> mm = service.findById(Integer.parseInt(id), Test.class);
		String object = (String) mm.get("version");
        
        m.put("name", name);
        m.put("unit", unit);
        m.put("count",count);
        m.put("recvdate", recvdate);
        m.put("testdate", testdate);
        m.put("proddate", proddate);
        m.put("testcode", testcode);
        m.put("provid", provid);
        m.put("person", person);
        m.put("project", project);
        m.put("conclusion", conclusion);
        m.put("detail", detail);
       try {
		service.update(m, createid, Test.class,object, id);
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
        
        
       return "/InterFace/TestFrame/Testindex.jsp";
	}


	
	
	public String SelectTest(HttpServletRequest req, HttpServletResponse resp)
			throws DaoException{
		//System.out.println(id);
		String name= req.getParameter("name");
		String count = req.getParameter("count");
		String testcode = req.getParameter("testcode");
		String testdate = req.getParameter("testdate");
		String person = req.getParameter("person");
		List<Test> result = service.findTestByCondition(name,count, testcode, testdate, person);
		req.setAttribute("test", result);
		return "/InterFace/TestFrame/Testindex.jsp";
	}	
	
	public String SearchTest(HttpServletRequest req, HttpServletResponse resp)
				throws DaoException{
			//System.out.println(id);
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String unit = req.getParameter("unit");
		String count = req.getParameter("count");
		String proddate = req.getParameter("proddate");
		String recvdate = req.getParameter("recvdate");
		String testdate = req.getParameter("testdate");
		String testcode = req.getParameter("testcode");
		String provid = req.getParameter("provid");
		String person = req.getParameter("person");
		String project = req.getParameter("project");
		String conclusion = req.getParameter("conclusion");
		String detail = req.getParameter("detail");
		Map<String, Object> result = service.findById(id, Test.class);
		req.setAttribute("test", result);
		return "/InterFace/TestFrame/updateTest.jsp";
	}
}	
	
