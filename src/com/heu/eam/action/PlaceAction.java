package com.heu.eam.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.heu.eam.dao.pojo.Place;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.dao.pojo.Test;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.PlaceService;
import com.heu.eam.service.impl.PlaceServiceImpl;
import com.heu.eam.utils.SessionUtil;

/**
 * Servlet implementation class PersonAction
 */
public class PlaceAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static PlaceService service = new PlaceServiceImpl();

	public String addPlace(HttpServletRequest req,
			HttpServletResponse response) throws DaoException {
		String id = req.getParameter("id");
		String name= req.getParameter("name");
		String type= req.getParameter("type");
		String state= req.getParameter("state");
		String area = req.getParameter("area");
		String person = req.getParameter("person");
		String tel = req.getParameter("tel");
		String detail = req.getParameter("detail");
		Place place = new Place();
		place.setId(Integer.parseInt(SessionUtil.getId(req, response)));
		place.setName(name);
		place.setType(type);
		place.setState(state);
		place.setArea(area);
		place.setPerson(person);
		place.setTel(tel);
		place.setDetail(detail);
		
		place.setCreateId(Integer.parseInt(SessionUtil.getId(req, response)));
	    service.save(place);
		return "/InterFace/PlaceFrame/Placeindex.jsp";
	}

	public String deletePlace(HttpServletRequest req,
			HttpServletResponse response) throws DaoException {
		String id = req.getParameter("id");
		System.out.println(id);
		Integer [] ids = new Integer[1];
	     ids[0] = Integer.parseInt(id);
	
		service.delete(ids,Place.class,1);
		return "/InterFace/PlaceFrame/Placeindex.jsp";
	}

	public String findPersonByConditionPlace(HttpServletRequest req,
			HttpServletResponse response) {
		String id = req.getParameter("id");
		String name= req.getParameter("name");
		String type= req.getParameter("type");
		String state= req.getParameter("state");
		Map<String,String> map = new HashMap<String, String>();
		if (id.isEmpty() && name.isEmpty() && type.isEmpty() && state.equals("0")) {
			map = null;
		}
		else {		
			if (!id.isEmpty()) {
				map.put("id", id);
			}
			if (!name.isEmpty()) {
				map.put("name", name);
			}
			if (!type.isEmpty()) {
				map.put("type", type);
			}
			if (!state.equals("0")) {
				map.put("state", state);
			}
		}
		
		List<Map<String, Object>> result = null;
		try {
			result = service.findBy(map,Place.class);
			System.out.println(result);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("Places", result);
		return "/InterFace/PlaceFrame/Placeindex.jsp";
	}

	public String updatePlace(HttpServletRequest req,
			HttpServletResponse response) throws DaoException, ServiceBusinessException {
		System.out.println("111");
		String id = req.getParameter("id");
		String name= req.getParameter("name");
		String type= req.getParameter("type");
		String state= req.getParameter("state");
		String area = req.getParameter("area");
		String person = req.getParameter("person");
		String tel = req.getParameter("tel");
		String detail = req.getParameter("detail");
		String version = req.getParameter("version");

		Place place = new Place();
		place.setId(Integer.parseInt(id));
		place.setName(name);
		place.setType(type);
		place.setState(state);
		place.setArea(area);
		place.setPerson(person);
		place.setTel(tel);
		place.setDetail(detail);
		Map<String,String> map= new HashMap<String,String>();
		map.put("name",name);
		map.put("type", type);
		map.put("state", state);
		map.put("area", area);
		map.put("person",person);
		map.put("tel",tel);
		map.put("detail",detail);
		
		Map<String,Object> m = service.findById(Integer.parseInt(id), Place.class);System.out.println("777");
		String object = (String) m.get("version");
		System.out.println(id);
			service.update(map,SessionUtil.getId(req, response), Place.class, object, id);
		
		return "/InterFace/PlaceFrame/Placeindex.jsp";
	}
	
	public String SearchPlace(HttpServletRequest req, HttpServletResponse resp)
			throws DaoException{
		//System.out.println(id);
	int id = Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	String type = req.getParameter("type");
	String state = req.getParameter("state");
	String area = req.getParameter("area");
	String person = req.getParameter("person");
	String tel = req.getParameter("tel");
	String detail = req.getParameter("detail");
	Map<String, Object> result = service.findById(id, Place.class);
	req.setAttribute("place", result);
	return "/InterFace/PlaceFrame/updatePlace.jsp";
}

}
