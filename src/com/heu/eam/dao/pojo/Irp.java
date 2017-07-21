package com.heu.eam.dao.pojo;

public class Irp {

	
	private int id;
	private String path;
	private String name;			//英文名
	private Integer pid=null;      	//父类id 一级菜单的父类默认为0
	private String cname;			//中文名
	private String detal;			//说明
	private String del="0";         //是否删除
	private Integer  code;           //新增code
	private String state;             //是否显示
	private int createId;
	private String createtime;
	private int updateId;
	private String updatetime;
	private int version;
	public Irp() {
		super();
	}
	
	public Irp(String path, String name, Integer pid, String cname,
			String detal, String del, Integer code, String state) {
		super();
		this.path = path;
		this.name = name;
		this.pid = pid;
		this.cname = cname;
		this.detal = detal;
		this.del = del;
		this.code = code;
		this.state = state;
	}

	public Irp(int id, String path, String name, Integer pid, String cname,
			String detal, String del, Integer code, String state, int createId,
			String createtime, int updateId, String updatetime, int version) {
		super();
		this.id = id;
		this.path = path;
		this.name = name;
		this.pid = pid;
		this.cname = cname;
		this.detal = detal;
		this.del = del;
		this.code = code;
		this.state = state;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDetal() {
		return detal;
	}

	public void setDetal(String detal) {
		this.detal = detal;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public Integer getCode() {
		return code;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	public void setCode(Integer code) {
		this.code = code;
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

	@Override
	public String toString() {
		return "Irp [id=" + id + ", path=" + path + ", name=" + name + ", pid="
				+ pid + ", cname=" + cname + ", detal=" + detal + ", del="
				+ del + ", code=" + code + ", createId=" + createId
				+ ", createtime=" + createtime + ", updateId=" + updateId
				+ ", updatetime=" + updatetime + ", version=" + version + "]";
	}

	
	
}
