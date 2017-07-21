package com.heu.eam.dao;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.PersonToRole;
import com.heu.eam.dao.pojo.Roletoirp;

public interface PersonToRoleDao extends BaseDao<PersonToRole> {

	public Map<String,List<String>> find(String name);
	List<String> findName();
	int deletePersonToRoleId(int id);
	List<String> deleteByRoleName(String name);
}
