package com.heu.eam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.dao.pojo.Item;
import com.heu.eam.dao.pojo.Place;
import com.heu.eam.dao.pojo.Provider;
import com.heu.eam.dao.pojo.Test;
import com.heu.eam.dao.pojo.Type;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.BaseService;
import com.heu.eam.service.DeptService;
import com.heu.eam.service.ItemService;
import com.heu.eam.service.PlaceService;
import com.heu.eam.service.ProviderService;
import com.heu.eam.service.TestService;
import com.heu.eam.service.TypeService;
import com.heu.eam.service.impl.BaseServiceImpl;
import com.heu.eam.service.impl.DeptServiceImpl;
import com.heu.eam.service.impl.ItemServiceImpl;
import com.heu.eam.service.impl.PlaceServiceImpl;
import com.heu.eam.service.impl.ProviderServiceImpl;
import com.heu.eam.service.impl.TestServiceImpl;
import com.heu.eam.service.impl.TypeServiceImpl;
import com.heu.eam.utils.SessionUtil;

public class ItemAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemService itemService = new ItemServiceImpl();
	private PlaceService placeService = new PlaceServiceImpl();
	private DeptService deptService = new DeptServiceImpl();
	private TestService testService = new TestServiceImpl();
	private ProviderService providerService = new ProviderServiceImpl();
	private TypeService typeService = new TypeServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String operate = request.getParameter("itemOperate");
		if ("addItem".equals(operate)) {
			try {
				this.addItem(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("delete".equals(operate)) {
			this.delete(request, response);
		}
		if ("update".equals(operate)) {
			try {
				this.update(request, response);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ("list".equals(operate)) {
			this.list(request, response);
		}
		if ("listByPlaceId".equals(operate)) {
			this.listByPlaceId(request, response);
		}
		if ("deleteItem".equals(operate)) {
			this.deleteItem(request, response);
		}
		if ("updateItem".equals(operate)) {
			this.updateItem(request, response);
		}
		if ("updateItem".equals(operate)) {
			this.updateItem(request, response);
		}
	}

	private void updateItem(HttpServletRequest request,
			HttpServletResponse response) {
		int selected = Integer.parseInt(request.getParameter("selected"));
		Integer updateid = 1;
		try {
			Map<String, Object> item = itemService.findById(selected,
					Item.class);
			Map<String, Object> test = testService
					.findById(Integer.parseInt(item.get("testId").toString()),
							Test.class);
			Map<String, Object> type = typeService
					.findById(Integer.parseInt(item.get("typeId").toString()),
							Type.class);
			Map<String, Object> provider = providerService.findById(
					Integer.parseInt(item.get("provId").toString()),
					Provider.class);
			Map<String, Object> dept = deptService
					.findById(Integer.parseInt(item.get("deptId").toString()),
							Dept.class);
			Map<String, Object> place = placeService.findById(
					Integer.parseInt(item.get("placeId").toString()),
					Place.class);
			item.put("testName", test.get("name"));
			item.put("typeName", type.get("name"));
			item.put("provName", provider.get("name"));
			item.put("deptName", dept.get("name"));
			item.put("placeName", place.get("name"));
			request.setAttribute("item", item);
			request.getRequestDispatcher("/InterFace/item/itemupdate.jsp")
					.forward(request, response);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 展示指定placeId的Item
	 * 
	 * @param request
	 * @param response
	 */
	private void listByPlaceId(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String placeStr = request.getParameter("placeId");
			List<Map<String, Object>> items = null;
			if (placeStr == null || placeStr.length() == 0 || !isInt(placeStr)) {
				items = itemService.findAll(Item.class);
			} else {
				int placeId = Integer.parseInt(placeStr);
				items = itemService.findByPlaceId(placeId);
			}
			for (Map<String, Object> map : items) {
				Map<String, Object> test = testService.findById(
						Integer.parseInt(map.get("testId").toString()),
						Test.class);
				Map<String, Object> type = typeService.findById(
						Integer.parseInt(map.get("typeId").toString()),
						Type.class);
				Map<String, Object> provider = providerService.findById(
						Integer.parseInt(map.get("provId").toString()),
						Provider.class);
				Map<String, Object> dept = deptService.findById(
						Integer.parseInt(map.get("deptId").toString()),
						Dept.class);
				Map<String, Object> place = placeService.findById(
						Integer.parseInt(map.get("placeId").toString()),
						Place.class);
				map.put("testName", test.get("name"));
				map.put("typeName", type.get("name"));
				map.put("provName", provider.get("name"));
				map.put("deptName", dept.get("name"));
				map.put("placeName", place.get("name"));
			}
			request.setAttribute("items", items);
			request.getRequestDispatcher("/InterFace/item/itemmain.jsp")
					.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isInt(String placeStr) {
		try {
			Integer.parseInt(placeStr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 展示所有Item
	 * 
	 * @param request
	 * @param response
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Map<String, Object>> items = itemService.findAll(Item.class);
			for (Map<String, Object> map : items) {
				Map<String, Object> test = testService.findById(
						Integer.parseInt(map.get("testId").toString()),
						Test.class);
				Map<String, Object> type = typeService.findById(
						Integer.parseInt(map.get("typeId").toString()),
						Type.class);
				Map<String, Object> provider = providerService.findById(
						Integer.parseInt(map.get("provId").toString()),
						Provider.class);
				Map<String, Object> dept = deptService.findById(
						Integer.parseInt(map.get("deptId").toString()),
						Dept.class);
				Map<String, Object> place = placeService.findById(
						Integer.parseInt(map.get("placeId").toString()),
						Place.class);
				map.put("testName", test.get("name"));
				map.put("typeName", type.get("name"));
				map.put("provName", provider.get("name"));
				map.put("deptName", dept.get("name"));
				map.put("placeName", place.get("name"));
			}
			request.setAttribute("items", items);
			request.getRequestDispatcher("/InterFace/item/itemmain.jsp")
					.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 更新Item
	 * 
	 * @param request
	 * @param response
	 * @throws DaoException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws DaoException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		PrintWriter out = response.getWriter();
		Map<String, Object> result = new HashMap<String, Object>();
		String name = request.getParameter("name");
		if (name != null && name.length() > 0) {
			name = request.getParameter("name");
		} else {
			result.put("status", 1008);
			result.put("msg", "商品名称不能为空！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}

		double price = 0.0;
		String priceStr = request.getParameter("price");
		if (isDouble(priceStr))
			price = Double.parseDouble(request.getParameter("price"));
		else {
			result.put("status", 1007);
			result.put("msg", "价格错误！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}

		String placeName = request.getParameter("placeName");
		List<Place> places = placeService.findPlaceByName(placeName);

		if (places == null || places.size() == 0) {
			result.put("status", 1001);
			result.put("msg", "场地不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}

		int placeId = places.get(0).getId();

		// 查询deptId
		String deptName = request.getParameter("deptName");
		map.put("name", deptName);
		List<Map<String, Object>> depts = testService.findBy(map, Dept.class);
		if (depts == null || depts.size() == 0) {
			result.put("status", 1002);
			result.put("msg", "部门不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int deptId = Integer.parseInt(depts.get(0).get("id").toString());

		// 查询testId
		String testName = request.getParameter("testName");
		map.put("name", testName);
		List<Map<String, Object>> tests = testService.findBy(map, Test.class);
		if (tests == null || tests.size() == 0) {
			result.put("status", 1003);
			result.put("msg", "未经过" + testName + "检验！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		} else if ("不合格".equals(tests.get(0).get("conclusion"))) {
			result.put("status", 1004);
			result.put("msg", "检验不合格！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int testId = Integer.parseInt(tests.get(0).get("id").toString());

		String buyerName = request.getParameter("buyerName");

		// 查询provId
		String provName = request.getParameter("provName");
		map.put("name", provName);
		List<Map<String, Object>> provs = providerService.findBy(map,
				Provider.class);
		if (provs == null || provs.size() == 0) {
			result.put("status", 1005);
			result.put("msg", "供应商不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int provId = Integer.parseInt(provs.get(0).get("id").toString());

		// 查询typeId
		String typeName = request.getParameter("typeName");
		map.put("name", typeName);
		List<Map<String, Object>> types = typeService.findBy(map, Type.class);
		if (types.size() == 0) {
			result.put("status", 1006);
			result.put("msg", "该资产类型不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int typeId = Integer.parseInt(types.get(0).get("id").toString());

		String enterDate = request.getParameter("enterDate");

		String itemId = request.getParameter("itemId");
		String version = request.getParameter("version");

		Map<String, String> updateMap = new HashMap<String, String>();
		updateMap.put("name", name);
		updateMap.put("price", String.valueOf(price));
		updateMap.put("placeId", String.valueOf(placeId));
		updateMap.put("deptId", String.valueOf(deptId));
		updateMap.put("testId", String.valueOf(testId));
		updateMap.put("buyerName", buyerName);
		updateMap.put("provId", String.valueOf(provId));
		updateMap.put("typeId", String.valueOf(typeId));
		updateMap.put("enterDate", enterDate);
		try {
			itemService.update(updateMap, "1", Item.class, version, itemId);
			result.put("status", 1000);
			result.put("msg", "更新成功！");
			response.sendRedirect(request.getContextPath()
					+ "/ItemAction?itemOperate=list");
		} catch (ServiceBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> items;
		try {
			items = itemService.findAll(Item.class);
			request.setAttribute("items", items);
			request.getRequestDispatcher("/InterFace/item/itemdelete.jsp")
					.forward(request, response);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteItem(HttpServletRequest request,
			HttpServletResponse response) {
		String selected = request.getParameter("selected");
		String[] temp = selected.split(",");
		Integer[] result = new Integer[temp.length];// int类型数组
		for (int i = 0; i < temp.length; i++) {
			result[i] = Integer.parseInt(temp[i]);// 整数数组
		}
		Integer updateid = 1;
		try {
			itemService.delete(result, Item.class, updateid);
			response.sendRedirect(request.getContextPath()
					+ "/ItemAction?itemOperate=list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加Item
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws DaoException
	 * @throws ServletException
	 */
	private void addItem(HttpServletRequest request,
			HttpServletResponse response) throws IOException, DaoException,
			ServletException {
		Map<String, String> map = new HashMap<String, String>();
		PrintWriter out = response.getWriter();
		Map<String, Object> result = new HashMap<String, Object>();
		String name = request.getParameter("name");
		if (name != null && name.length() > 0) {
			name = request.getParameter("name");
		} else {
			result.put("status", 1008);
			result.put("msg", "商品名称不能为空！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}

		double price = 0.0;
		String priceStr = request.getParameter("price");
		if (isDouble(priceStr))
			price = Double.parseDouble(request.getParameter("price"));
		else {
			result.put("status", 1007);
			result.put("msg", "价格错误！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}

		// 查询placeId
		String placeName = request.getParameter("placeName");
		List<Place> places = placeService.findPlaceByName(placeName);

		if (places == null || places.size() == 0) {
			result.put("status", 1001);
			result.put("msg", "场地不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}

		int placeId = places.get(0).getId();

		// 查询deptId
		String deptName = request.getParameter("deptName");
		map.put("name", deptName);
		List<Map<String, Object>> depts = testService.findBy(map, Dept.class);
		if (depts == null || depts.size() == 0) {
			result.put("status", 1002);
			result.put("msg", "部门不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int deptId = Integer.parseInt(depts.get(0).get("id").toString());

		// 查询testId
		String testName = request.getParameter("testName");
		map.put("name", testName);
		List<Map<String, Object>> tests = testService.findBy(map, Test.class);
		if (tests == null || tests.size() == 0) {
			result.put("status", 1003);
			result.put("msg", "未经过" + testName + "检验！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		} else if ("不合格".equals(tests.get(0).get("conclusion"))) {
			result.put("status", 1004);
			result.put("msg", "检验不合格！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int testId = Integer.parseInt(tests.get(0).get("id").toString());

		String buyerName = request.getParameter("buyerName");

		// 查询provId
		String provName = request.getParameter("provName");
		map.put("name", provName);
		List<Map<String, Object>> provs = providerService.findBy(map,
				Provider.class);
		if (provs == null || provs.size() == 0) {
			result.put("status", 1005);
			result.put("msg", "供应商不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int provId = Integer.parseInt(provs.get(0).get("id").toString());

		// 查询typeId
		String typeName = request.getParameter("typeName");
		map.put("name", typeName);
		List<Map<String, Object>> types = typeService.findBy(map, Type.class);
		if (types.size() == 0) {
			result.put("status", 1006);
			result.put("msg", "该资产类型不存在！");
			out.println("<script>alert('" + result.get("msg")
					+ "');window.history.go(-1)</script>");
			return;
		}
		int typeId = Integer.parseInt(types.get(0).get("id").toString());

		String enterDate = request.getParameter("enterDate");

		Item item = new Item(name, price, placeId, deptId, testId, buyerName,
				provId, typeId, enterDate);
		item.setDel("0");
		item.setCreateId(Integer.parseInt(SessionUtil.getId(request, response)));
		itemService.save(item);

		result.put("status", 1000);
		result.put("msg", "保存成功！");
		response.sendRedirect(request.getContextPath()
				+ "/ItemAction?itemOperate=list");
	}

	private Boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	}

