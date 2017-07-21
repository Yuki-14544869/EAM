package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.RoleDao;
import com.heu.eam.dao.impl.RoleDaoImpl;
import com.heu.eam.dao.pojo.Role;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.RoleService;

public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {
	private RoleDao dao = new RoleDaoImpl();

	@Override
	public List<Role> findByElement(String id, String name, String state) {
		// TODO Auto-generated method stub
		return dao.findByElement(id, name, state);
	}

}
