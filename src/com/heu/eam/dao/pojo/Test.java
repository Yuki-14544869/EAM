
	package com.heu.eam.dao.pojo;

	public class Test {
	    
		private int id;
		private String name;
		private String unit;
		private String count;
		private String proddate;
		private String recvdate;
		private String testdate;
		private String provid;
		private String person;
		private String project;
		private String conclusion;
		private String testcode;
		private String detail;
		private String del="0";
		private int createId;
		private String createtime;
		private int updateId;
		private String updatetime;
		private int version;
		public Test(int id, String name, String unit, String count,
				String proddate, String recvdate, String testdate,
				String provid, String person, String project,
				String conclusion, String testcode, String detail, String del,
				int createId, String createtime, int updateId,
				String updatetime, int version) {
			super();
			this.id = id;
			this.name = name;
			this.unit = unit;
			this.count = count;
			this.proddate = proddate;
			this.recvdate = recvdate;
			this.testdate = testdate;
			this.provid = provid;
			this.person = person;
			this.project = project;
			this.conclusion = conclusion;
			this.testcode = testcode;
			this.detail = detail;
			this.del = del;
			this.createId = createId;
			this.createtime = createtime;
			this.updateId = updateId;
			this.updatetime = updatetime;
			this.version = version;
		}
		public Test() {
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
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public String getProddate() {
			return proddate;
		}
		public void setProddate(String proddate) {
			this.proddate = proddate;
		}
		public String getRecvdate() {
			return recvdate;
		}
		public void setRecvdate(String recvdate) {
			this.recvdate = recvdate;
		}
		public String getTestdate() {
			return testdate;
		}
		public void setTestdate(String testdate) {
			this.testdate = testdate;
		}
		public String getProvid() {
			return provid;
		}
		public void setProvid(String provid) {
			this.provid = provid;
		}
		public String getPerson() {
			return person;
		}
		public void setPerson(String person) {
			this.person = person;
		}
		public String getProject() {
			return project;
		}
		public void setProject(String project) {
			this.project = project;
		}
		public String getConclusion() {
			return conclusion;
		}
		public void setConclusion(String conclusion) {
			this.conclusion = conclusion;
		}
		public String getTestcode() {
			return testcode;
		}
		public void setTestcode(String testcode) {
			this.testcode = testcode;
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