package com.heu.eam.service;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.PersonToRole;

public interface PersonToRoleService extends BaseService<PersonToRole> {

	void delete(int pid, int rid);
	void save(PersonToRole personToRole);
	public Map<String,List<String>> findall(String name);
	public List<String> findName();
	public List<String> deleteByRoleName(String name);
}
