package com.heu.eam.dao.pojo;

public class Provider {
	private int id;
	private String name;
	private String perid;
	private String tel;
	private String mail;
	private String url;
	private String address;
	private String bankaccount;
	private String state;
	private String del="0";
	private int createId;
	private String createtime;
	private int updateId;
	private String updatetime;
	private int version;
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
	public String getPerid() {
		return perid;
	}
	public void setPerid(String perid) {
		this.perid = perid;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public Provider(int id, String name, String perid, String tel, String mail,
			String url, String address, String bankaccount, String state,
			String del, int createId, String createtime, int updateId,
			String updatetime, int version) {
		super();
		this.id = id;
		this.name = name;
		this.perid = perid;
		this.tel = tel;
		this.mail = mail;
		this.url = url;
		this.address = address;
		this.bankaccount = bankaccount;
		this.state = state;
		this.del = del;
		this.createId = createId;
		this.createtime = createtime;
		this.updateId = updateId;
		this.updatetime = updatetime;
		this.version = version;
	}
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
