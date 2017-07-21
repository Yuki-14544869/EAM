package com.heu.eam.dao.pojo;

public class Plan {
   private int id;
   private String title;
   private String subtime;
   private int  sdid;
   private int  cdid;
   private String text;
   private String detail;
   private String response;
   private int state;
   private String del="0";
   private int createId;
   private String createtime;
   private int updateId;
   private String updatetime;
   private int version;
public Plan() {
	super();
	// TODO Auto-generated constructor stub
}
public Plan(int id, String title, String subtime, int sdid, int cdid,
		String text, String detail, String response, int state, String del,
		int createId, String createtime, int updateId, String updatetime,
		int version) {
	super();
	this.id = id;
	this.title = title;
	this.subtime = subtime;
	this.sdid = sdid;
	this.cdid = cdid;
	this.text = text;
	this.detail = detail;
	this.response = response;
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
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSubtime() {
	return subtime;
}
public void setSubtime(String subtime) {
	this.subtime = subtime;
}
public int getSdid() {
	return sdid;
}
public void setSdid(int sdid) {
	this.sdid = sdid;
}
public int getCdid() {
	return cdid;
}
public void setCdid(int cdid) {
	this.cdid = cdid;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public String getResponse() {
	return response;
}
public void setResponce(String response) {
	this.response = response;
}
public int getState() {
	return state;
}
public void setState(int state) {
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