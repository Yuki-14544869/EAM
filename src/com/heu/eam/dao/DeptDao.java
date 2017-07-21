package com.heu.eam.dao;

import java.util.List;

import com.heu.eam.dao.pojo.Dept;
import com.heu.eam.dao.pojo.Role;

public interface DeptDao extends BaseDao<Dept> {
	List<Dept> findDeptByCondition(int id,String name);
	   List<Dept> findDeptByName(String name);
	   List<Dept> findChildDept(int pid);
	   Dept findByName(String name);
	   int addDept(Dept dept);
	   int deleteDeptById(int id);
	   int updateDept(Dept dept);
	List<Dept> findByElement(String id,String name, String pid, String personid);
	
	
}
