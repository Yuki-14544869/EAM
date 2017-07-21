package com.heu.eam.service;

import java.util.List;
import java.util.Map;

import com.heu.eam.dao.pojo.Roletoirp;


public interface RoleToIrpService extends BaseService<Roletoirp>{
    Map<String,List<String>> findAll(String name);
    public List<Map<String,String>> findName();
    public List<Map<String, String>> deleteByRoleName(String name);
}
