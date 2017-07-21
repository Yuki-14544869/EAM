package com.heu.eam.service;

import java.util.List;

import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.dao.pojo.Role;

public interface DeptService extends BaseService<Dept>{

	void update(Dept d);

	List<Dept> findByElement(String id,String name, String pid, String personid);
	
		
}
