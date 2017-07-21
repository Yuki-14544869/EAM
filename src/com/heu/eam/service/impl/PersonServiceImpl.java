package com.heu.eam.service.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.heu.eam.dao.PersonDao;
import com.heu.eam.dao.impl.PersonDaoImpl;
import com.heu.eam.dao.pojo.Person;
import com.heu.eam.exception.DaoException;
import com.heu.eam.exception.ServiceBusinessException;
import com.heu.eam.service.PersonService;

public class PersonServiceImpl extends BaseServiceImpl<Person> implements
		PersonService {
    private PersonDao dao = new PersonDaoImpl();
	
	@Override
	public Map<String, Map<String, String>> getIrp(String id)
			throws DaoException {
		// TODO Auto-generated method stub
		PersonDao pd = new PersonDaoImpl();
		Map<String, Map<String, String>> irp = pd.getIrp(id);
		return irp;
	}

	


	@Override
	public Map<String, Object> textLogin(String userName, String password) throws ServiceBusinessException {
		try {
			return dao.textLogin(userName, password);
		} catch (DaoException e) {
			throw new ServiceBusinessException("用户名密码登录异常",e);
		}
	}

}
