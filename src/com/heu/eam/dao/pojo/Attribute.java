package com.heu.eam.dao.pojo;

public class Attribute {
    private int id;
    private String name;
    private String detail;
    private int createId;
	private String createtime;
	private int updateId;
	private String updatetime;
	private int version;

	public Attribute() {
		super();
	}
	
	public Attribute(int id, String name, int createId, String createtime,
			int updateId, String updatetime, int version) {
		super();
		this.id = id;
		this.name = name;
		this.createId = createId;
		this.createtime = createtime;
		this.updateId = updateId;
		this.updatetime = updatetime;
		this.version = version;
	}

	public Attribute(int id, String name, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
	}

	public int getId() {
		return id;
	}

	public Attribute(String name, String detail) {
		super();
		this.name = name;
		this.detail = detail;
	}
	
	public Attribute(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
