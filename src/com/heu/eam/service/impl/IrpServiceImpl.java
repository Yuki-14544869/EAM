package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.IrpDao;
import com.heu.eam.dao.impl.IrpDaoImpl;
import com.heu.eam.dao.pojo.Irp;
import com.heu.eam.exception.DaoException;
import com.heu.eam.service.IrpService;

public class IrpServiceImpl extends  BaseServiceImpl<Irp> implements IrpService{
	public void save(Irp i) {
		IrpDao ip = new IrpDaoImpl();
		try {
			ip.save(i);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Irp> findByName(String name)
			throws DaoException {
		IrpDao ip = new IrpDaoImpl();
		List<Irp> map = ip.findByName(name);
		return map;
	}

	@Override
	public Map<String, Object> findByPid(int pid) throws DaoException {
		Irp irp = new Irp();
		IrpDao ip = new IrpDaoImpl();
		Map<String, Object> map = ip.findById(pid, irp.getClass());
		return map;
	}

	@Override
	public Map<String, Object> findByDel(String del) throws DaoException {
		IrpDao ip = new IrpDaoImpl();
		Map<String, Object> map = ip.findByDel(del);
		return map;
	}

	@Override
	public List<Map<String, Object>> findAll() throws DaoException {
		IrpDao ip = new IrpDaoImpl();
		List<Map<String, Object>> map = ip.findAll();
		return map;
	};
}
