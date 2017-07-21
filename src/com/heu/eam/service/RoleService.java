package com.heu.eam.service;

import java.util.List;

import com.heu.eam.dao.pojo.Role;

public interface RoleService extends BaseService<Role>{

	List<Role> findByElement(String id, String name, String state);
	
}
