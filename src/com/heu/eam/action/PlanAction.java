package com.heu.eam.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;

import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.dao.pojo.Person;
import com.heu.eam.dao.pojo.Plan;
import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.DeptService;
import com.heu.eam.service.PersonService;
import com.heu.eam.service.PlanService;
import com.heu.eam.service.ProviderService;
import com.heu.eam.service.impl.DeptServiceImpl;
import com.heu.eam.service.impl.PersonServiceImpl;
import com.heu.eam.service.impl.PlanServiceImpl;
import com.heu.eam.service.impl.ProviderServiceImpl;
import com.heu.eam.utils.DateUtil;

public class PlanAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private PlanService service = new PlanServiceImpl();
	private static int i = 0;

	public String addPlan(HttpServletRequest request, HttpServletResponse res)
			throws IOException {
		Plan plan = new Plan();
		int i;
		String time = DateUtil.dateToString(new Date());
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");
		String title = request.getParameter("title");
		String text = "";
		String[] product = request.getParameterValues("product");
		String[] number1 = request.getParameterValues("number1");
		String[] price = request.getParameterValues("price");
		String detail = request.getParameter("detail");

		for (i = 0; i < product.length; ++i) {
			text += product[i] + "-" + number1[i] + "-" + price[i];
			if (i != product.length - 1)
				text += "|";
		}

		int createid = Integer.parseInt((String) msgMap.get("id"));
		int updateid = createid;
		PersonService personService = new PersonServiceImpl();
		DeptService deptService = new DeptServiceImpl();
		Map<String, Object> userinfo = null;
		try {
			userinfo = personService.findById(createid, Person.class);
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int cdid = Integer.parseInt(String.valueOf(userinfo.get("deptid")));
		//
		Map<String, Object> fatherdeptinfo = null;
		int sdid;
		try {
			fatherdeptinfo = deptService.findById(cdid, Dept.class);
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sdid = Integer.parseInt(String.valueOf(fatherdeptinfo.get("pid")));
		plan.setTitle(title);
		plan.setSubtime(time);
		plan.setSdid(sdid);
		plan.setCdid(cdid);
		plan.setText(text);
		plan.setDetail(detail);
		// plan.setResponce();
		plan.setState(0);
		// plan.setCreateId(Integer.parseInt(createdId));
		plan.setCreateId(createid);
		plan.setDel("0");

		try {
			service.save(plan);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		res.sendRedirect("PlanAction?method=listUnsubmitedPlan");
		return null;
	}

	public String delPlan(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Map<String, Object> msgMap = (Map<String, Object>) req.getSession()
				.getAttribute("user");

		int updateid = Integer.parseInt((String) msgMap.get("deptid"));
		try {
			service.delete(id, updateid);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		res.sendRedirect("PlanAction?method=listUnsubmitedPlan");

		return null;
	}

	public String findallPlan(HttpServletRequest req, HttpServletResponse res) {
		List<Map<String, Object>> planlist = null;
		try {
			planlist = service.findAll(Plan.class);
		} catch (DaoException e) {
			e.printStackTrace();
		}

		req.setAttribute("plans", planlist);

		return "InterFace/Plan/UnSubPlan.jsp";
	}

	public String listUnsubmitedPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int state = 0;
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");
		String deptid = (String) msgMap.get("deptid");
		System.out.println("部门id为"+deptid);
		int cdid = Integer.parseInt(deptid);
		System.out.println(cdid);
		List<Map<String, Object>> planlist = null;
		try {
			planlist = service.findMyplan(state, cdid, Plan.class);

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("plans", planlist);
		request.setAttribute("plansnum", planlist.size());
		System.out.println("一共有" + planlist.size() + "行数据");
		return "InterFace/Plan/UnSubPlan.jsp";
	}

	public String listSubmitedPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int state = 1;
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");
		String deptid = (String) msgMap.get("deptid");
		int sdid = Integer.parseInt(deptid);
		List<Map<String, Object>> planlist = null;
		try {
			planlist = service.findByState(state, sdid, Plan.class);

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("plans", planlist);
		request.setAttribute("plansnum", planlist.size());
		System.out.println("一共有" + planlist.size() + "行数据");
		return "InterFace/Plan/UnprocessedPlan.jsp";
	}

	public String listPassedPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int state = 2;
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");
		String deptid = (String) msgMap.get("deptid");
		int cdid = Integer.parseInt(deptid);
		System.out.println(cdid);
		List<Map<String, Object>> planlist = null;
		try {
			planlist = service.findMyplan(state, cdid, Plan.class);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("plans", planlist);
		request.setAttribute("plansnum", planlist.size());
		return "InterFace/Plan/PassedPlan.jsp";
	}

	public String listRefusedPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int state = 3;
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");
		String deptid = (String) msgMap.get("deptid");
		int cdid = Integer.parseInt(deptid);
		List<Map<String, Object>> planlist = null;
		try {
			planlist = service.findMyplan(state, cdid, Plan.class);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("plans", planlist);
		request.setAttribute("plansnum", planlist.size());
		return "InterFace/Plan/UnpassedPlan.jsp";
	}

	public String listProcessedPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int state = 2;
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");
		String deptid = (String) msgMap.get("deptid");
		int sdid = Integer.parseInt(deptid);
		System.out.println("该用户所属部门为" + sdid);
		List<Map<String, Object>> planlist1 = null;
		List<Map<String, Object>> planlist2 = null;
		try {
			planlist1 = service.findByState(state, sdid, Plan.class);
			if (!planlist1.isEmpty()) {
				System.out.println("取到了数据");
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state = 3;
		try {
			planlist2 = service.findByState(state, sdid, Plan.class);
			if (!planlist2.isEmpty()) {
				System.out.println("取到了数据");
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("Passed", planlist1);
		request.setAttribute("Refused", planlist2);
		request.setAttribute("plansnum1", planlist1.size());
		request.setAttribute("plansnum2", planlist2.size());
		request.setAttribute("plansnumSum", planlist1.size()+planlist2.size());

		return "InterFace/Plan/ProcessedPlan.jsp";
	}

	public String refusePlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession().getAttribute("user");
		String res = request.getParameter("response");
		String updateid = (String) msgMap.get("id");
		String version = request.getParameter("version");
		String id = request.getParameter("id");
		System.out.println("反馈内容为“" + res+"”");
		System.out.println("版本为" + version);
		Map<String, String> map = new HashMap<String, String>();
		map.put("state", "3");
		map.put("response", res);
		// try {
		// service.update(map, updateid, Plan.class, version, id);
		// } catch (DaoException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (ServiceBusinessException e) {
		// // TODO Auto-generated catch block
		// request.setAttribute("msg", arg1);
		// e.printStackTrace();
		// }

		try {
			System.out.println("准备执行更新");
			service.update(map, updateid, Plan.class, version, id);
			System.out.println("更新完毕");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceBusinessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", "数据已被更改，请刷新");
			response.sendRedirect("PlanAction?method=listUnprocessedPlan");
			e.printStackTrace();
		}

		response.sendRedirect("PlanAction?method=listProcessedPlan");
		return null;

	}

	public String passPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,

	ServiceBusinessException {

		Map<String, String> map = new HashMap<String, String>();
		map.put("state", "2");
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");

		String updateid = (String) msgMap.get("id");
		String version = request.getParameter("version");
		String mail = request.getParameter("mail");
		String id = request.getParameter("id");
		System.out.println("版本号为" + version);
		System.out.println("计划id为" + id);

		ProviderService proService = new ProviderServiceImpl();
		List<Map<String, Object>> providerlist = null;
		try {
			providerlist = proService.findAll(Provider.class);
		} catch (DaoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("查询到" + providerlist.size() + "个供应商");

		try {
			System.out.println("准备执行更新");
			service.update(map, updateid, Plan.class, version, id);
			// 取出供应商邮箱
			String to = "";
			for (int i = 0; i < providerlist.size(); i++) {
				if (String.valueOf(providerlist.get(i).get("mail")) != "null")
					to += String.valueOf(providerlist.get(i).get("mail")) + ",";
			}
			if (to != null)
				to = to.substring(0, to.length() - 1);
			try {
				System.out.println(to);
				// System.out.println(String.valueOf(providerlist.get(i).get("id")));
				// System.out.println(String.valueOf(providerlist.get(i).get("mail")));
				MailAction.sendmail(
						String.valueOf(providerlist.get(i).get("mail")), mail);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
			System.out.println("更新完毕");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("PlanAction?method=listProcessedPlan");
		return null;

	}

	public String checkingPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int state = 1;
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");
		String deptid = (String) msgMap.get("deptid");
		int cdid = Integer.parseInt(deptid);
		System.out.println(cdid);
		List<Map<String, Object>> planlist = null;
		try {
			planlist = service.findMyplan(state, cdid, Plan.class);

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("plans", planlist);
		request.setAttribute("plansnum", planlist.size());
		System.out.println("一共有" + planlist.size() + "行数据");
		return "InterFace/Plan/SubPlan.jsp";
	}

	public String subPlan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,

	ServiceBusinessException {

		Map<String, String> map = new HashMap<String, String>();
		map.put("state", "1");
		Map<String, Object> msgMap = (Map<String, Object>) request.getSession()
				.getAttribute("user");

		String updateid = (String) msgMap.get("id");
		String version = request.getParameter("version");
		String mail = request.getParameter("mail");
		String id = request.getParameter("id");
		System.out.println(version);
		System.out.println(id);

		DeptService deptService = new DeptServiceImpl();
		List<Map<String, Object>> deptinfoList = null;
		try {
			deptinfoList = deptService.findAll(Dept.class);
		} catch (DaoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			System.out.println("准备执行更新");
			service.update(map, updateid, Plan.class, version, id);
			System.out.println("更新完毕");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("PlanAction?method=checkingPlan");
		return null;

	}
}
