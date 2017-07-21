package com.heu.eam.dao;

import java.util.List;
import com.heu.eam.dao.pojo.Role;

public interface RoleDao extends BaseDao<Role> {
	List<Role> findByElement(String id, String name ,String state);
}
