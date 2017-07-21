package com.heu.eam.service.impl;

import java.util.List;

import com.heu.eam.dao.DeptDao;
import com.heu.eam.dao.impl.DeptDaoImpl;
import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.service.DeptService;


public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService{
    private DeptDao dao = new DeptDaoImpl();
    
	public void update(Dept d) {
		// TODO Auto-generated method stub
		
	}

	public List<Dept> findByElement(String id,String name, String pid, String personid) {
		// TODO Auto-generated method stub
		return dao.findByElement(id,name,pid,personid);
		
	}

}