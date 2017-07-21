package com.heu.eam.dao.pojo;

public class TypeToattr {
	private int id;
	private int typeid;
	private int attrid;
	private int createId;
	private String createtime;
	private int updateId;
	private String updatetime;
	private int version;

	public TypeToattr(int id, int typeid, int attrid) {
		super();
		this.id = id;
		this.typeid = typeid;
		this.attrid = attrid;
	}

	public TypeToattr() {
		super();
	}

	public int getCreateId() {
		return createId;
	}

	public void setCreateId(int createId) {
		this.createId = createId;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
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



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public int getAttrid() {
		return attrid;
	}

	public void setAttrid(int attrid) {
		this.attrid = attrid;
	}

}
