package com.heu.eam.dao.pojo;



public class Person {

	private int id;
	private String username;
	private String password;
	private String realname;
	private String sex;
	private String nat;
	private String borndate;
	private String hiredate;
	private int deptid;
	private String cardid;
	private String address;
	private String natpl;
	private String tel;
	private String mail;
	private String pos;
	private String state;
	private String del="0";
	private int createId;
	private String createtime;
	private int updateId;
	private String updatetime;
	private int version;
	
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(int id, String username, String password, String realname,
			String sex, String nat, String borndate, String hiredate,
			int deptid, String cardid, String address, String natpl,
			String tel, String mail, String pos, String state, String del,
			int createId, String createtime, int updateId, String updatetime,
			int version) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.nat = nat;
		this.borndate = borndate;
		this.hiredate = hiredate;
		this.deptid = deptid;
		this.cardid = cardid;
		this.address = address;
		this.natpl = natpl;
		this.tel = tel;
		this.mail = mail;
		this.pos = pos;
		this.state = state;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public String getBorndate() {
		return borndate;
	}
	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNatpl() {
		return natpl;
	}
	public void setNatpl(String natpl) {
		this.natpl = natpl;
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
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
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
	

}
