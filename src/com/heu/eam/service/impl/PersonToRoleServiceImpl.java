package com.heu.eam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.heu.eam.dao.PersonToRoleDao;
import com.heu.eam.dao.pojo.PersonToRole;
import com.heu.eam.dao.pojo.Roletoirp;
import com.heu.eam.service.PersonToRoleService;
import com.heu.eam.dao.impl.PersonToRoleDaoImpl;
import com.heu.eam.exception.DaoException;

public class PersonToRoleServiceImpl extends BaseServiceImpl<PersonToRole> implements PersonToRoleService {
          private PersonToRoleDaoImpl personToRoleDao=new PersonToRoleDaoImpl();

	public void save(PersonToRole personToRole){
		try {
			personToRoleDao.save(personToRole);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public Map<String, List<String>> findall(String name) {
		// TODO Auto-generated method stub
		return personToRoleDao.find(name);
	}


	@Override
	public void delete(int pid, int rid) {
		List<String> result = new ArrayList<String>();
		result=personToRoleDao.findName();
		int i=1;
		int id=0;
		PersonToRole  myId= new PersonToRole();
		personToRoleDao.deletePersonToRoleId(id);
		
	}


	@Override
	public List<String> findName() {
		// TODO Auto-generated method stub
		
		return personToRoleDao.findName();
	}


	@Override
	public List<String> deleteByRoleName(String name) {
		// TODO Auto-generated method stub
		return personToRoleDao.deleteByRoleName(name);
	}

}
