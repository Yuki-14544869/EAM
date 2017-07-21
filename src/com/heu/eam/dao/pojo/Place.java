package com.heu.eam.dao.pojo;

public class Place {
	private int id;
	private String name;
	private String type;
	private String state;
	private String area;
	private String person;
	private String tel;
	private String detail;
	private String del="0";
	private int createId;
	private String createtime;
	private int updateId;
	private String updatetime;
	private int version;
	
	public Place(int id, String name, String type, String state, String area,
			String person, String tel, String detail, String del, int createId,
			String createtime, int updateId, String updatetime, int version) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.state = state;
		this.area = area;
		this.person = person;
		this.tel = tel;
		this.detail = detail;
		this.del = del;
		this.createId = createId;
		this.createtime = createtime;
		this.updateId = updateId;
		this.updatetime = updatetime;
		this.version = version;
	}
	public Place() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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
	
