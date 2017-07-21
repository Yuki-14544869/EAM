package com.heu.eam.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.ProviderService;
import com.heu.eam.service.impl.ProviderServiceImpl;
import com.heu.eam.utils.SessionUtil;

public class ProviderAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Provider provider = new Provider();
	private ProviderService service = new ProviderServiceImpl();

	public String deleteProvider(HttpServletRequest req,
			HttpServletResponse response) throws DaoException {
		String id = req.getParameter("id");
		System.out.println(id);
		Integer[] ids = new Integer[1];
		ids[0] = Integer.parseInt(id);
		service.delete(ids, Provider.class, 1);
		System.out.println("我叫删除");
		return "/InterFace/provider/searchProvider.jsp";
	}

	public String newProvider(HttpServletRequest req, HttpServletResponse resp) {

		return "/InterFace/provider/searchProvider.jsp";
	}

	public String newnewProvider(HttpServletRequest req,
			HttpServletResponse resp) {

		return "/InterFace/provider/searchProvider.jsp";
	}

	public String addProvider(HttpServletRequest req, HttpServletResponse resp) {
		// String id = req.getParameter("id");
		String name = req.getParameter("name");
		String perid = req.getParameter("perid");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		String url = req.getParameter("url");
		String address = req.getParameter("address");
		String bankaccount = req.getParameter("bankaccount");
		String createid = SessionUtil.getId(req, resp);
		provider.setCreateId(Integer.parseInt(createid));
		// provider.setId(Integer.parseInt(id));
		provider.setName(name);
		provider.setPerid(perid);
		provider.setTel(tel);
		provider.setMail(mail);
		provider.setUrl(url);
		provider.setAddress(address);
		provider.setBankaccount(bankaccount);
		provider.setState("0");
		try {
			service.save(provider);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tianjia");
		return "/InterFace/provider/searchProvider.jsp";
	}

	public String findByCondition(HttpServletRequest req,
			HttpServletResponse resp) throws DaoException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String state = req.getParameter("state");
		String perid = req.getParameter("perid");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		String url = req.getParameter("url");

		String address = req.getParameter("address");
		String bankaccount = req.getParameter("bankaccount");
		List<Provider> rr = service.findProviderByCondition(id, name, perid,
				tel, mail, url, address, bankaccount);

		req.setAttribute("provider", rr);
		System.out.println("chazhao");
		return "/InterFace/provider/searchProvider.jsp";
	}

	public String SelectProvider(HttpServletRequest req,
			HttpServletResponse resp) throws DaoException {

		System.out.println("修xianxian改");
		int id = Integer.parseInt(req.getParameter("id"));
		Map<String, Object> result = service.findById(id, Provider.class);
		req.setAttribute("provider", result);
		System.out.println("修xian改");
		return "/InterFace/provider/updateProvider.jsp";
	}

	public String updateProvider(HttpServletRequest req,
			HttpServletResponse response) throws DaoException,
			ServiceBusinessException {
		System.out.println("111");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String perid = req.getParameter("perid");
		String tel = req.getParameter("tel");
		String mail = req.getParameter("mail");
		String url = req.getParameter("url");
		String address = req.getParameter("address");
		String bankaccount = req.getParameter("bankaccount");
		String state = req.getParameter("state");
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		map.put("state", state);
		map.put("name", name);
		map.put("perid", perid);
		map.put("tel", tel);
		map.put("mail", mail);
		map.put("url", url);
		map.put("address", address);
		map.put("bankaccount", bankaccount);

		Map<String, Object> m = service.findById(Integer.parseInt(id),
				Provider.class);
		System.out.println("777");
		String object = (String) m.get("version");
		System.out.println(id);
		service.update(map, "1", Provider.class, object, id);

		return "/InterFace/provider/searchProvider.jsp";
	}

}
