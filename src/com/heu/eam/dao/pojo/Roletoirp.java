package com.heu.eam.dao.pojo;

public class Roletoirp {
	
    private int id;
    private int roleid;
    private int irpid;
    private String del="0";
	private int createId;
	private String createtime;
	private int updateId;
	private String updatetime;
	private int version;

	public Roletoirp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roletoirp(int id, int roleid, int irpid, String del, int createId,
			String createtime, int updateId, String updatetime, int version) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.irpid = irpid;
		this.del = del;
		this.createId = createId;
		this.createtime = createtime;
		this.updateId = updateId;
		this.updatetime = updatetime;
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getIrpid() {
		return irpid;
	}

	public void setIrpid(int irpid) {
		this.irpid = irpid;
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
}
