package com.heu.eam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Roletoirp;	
import com.heu.eam.exception.DaoException;
import com.heu.eam.utils.DBUtil;
public interface RoletoirpDao extends BaseDao<Roletoirp> {
	Map<String,List<String>> find(String name);
	public List<Map<String,String>> findName();
	List<Map<String, String>> deleteByRoleName(String name);
}
