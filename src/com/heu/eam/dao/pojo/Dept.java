package com.heu.eam.dao.pojo;

import java.util.List;

public class Dept {
	
	private int id;
	private String name;
	private int pid;
	private int personid;
	private String del="0";
	private int createId;
	private String createtime;
	private int updateid;
	private String updatetime;
	private int version;
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(int id, String name, int pid, int personId, String del,
			int createid, String createtime, int updateid, String updatetime,
			int version) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.personid = personId;
		this.del = del;
		this.createId = createid;
		this.createtime = createtime;
		this.updateid = updateid;
		this.updatetime = updatetime;
		this.version = version;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public int getCreateId() {
		return createId;
	}
	public void setCreateId(int createid) {
		this.createId = createid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getUpdateid() {
		return updateid;
	}
	public void setUpdateid(int updateid) {
		this.updateid = updateid;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	

}

