package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import com.heu.eam.action.RoleToIrpAction;
import com.heu.eam.dao.RoletoirpDao;
import com.heu.eam.dao.impl.RoletoirpDaoImpl;
import com.heu.eam.dao.pojo.Roletoirp;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.RoleToIrpService;



public class RoleToIrpServiceImpl extends BaseServiceImpl<Roletoirp> implements RoleToIrpService{
	private RoletoirpDao roletoirpdao=new RoletoirpDaoImpl();
	
	public void save(Roletoirp roletoirp){
		try {
			roletoirpdao.save(roletoirp);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, List<String>> findAll(String name) {
		// TODO Auto-generated method stub
		return roletoirpdao.find(name);
	}
	public List<Map<String,String>> findName() {
		// TODO Auto-generated method stub
		
		return roletoirpdao.findName();
	}
	public List<Map<String, String>> deleteByRoleName(String name){
		return roletoirpdao.deleteByRoleName(name);
	}
}
