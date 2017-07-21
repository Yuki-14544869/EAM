package com.heu.eam.dao.pojo;

public class ItemToAttr {
	private Integer id;
	private Integer itemId;
	private Integer attrId;
	private String value;
	private String del;
	private Integer createId;
	private String createtime;
	private Integer updateid;
	private String updatetime;
	private Integer version;
	
	public ItemToAttr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemToAttr(Integer itemId, Integer attrId, String value) {
		super();
		this.itemId = itemId;
		this.attrId = attrId;
		this.value = value;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	/**
	 * @return the attrId
	 */
	public Integer getAttrId() {
		return attrId;
	}
	/**
	 * @param attrId the attrId to set
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the del
	 */
	public String getDel() {
		return del;
	}
	/**
	 * @param del the del to set
	 */
	public void setDel(String del) {
		this.del = del;
	}
	/**
	 * @return the createId
	 */
	public Integer getCreateId() {
		return createId;
	}
	/**
	 * @param createId the createId to set
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return the updateid
	 */
	public Integer getUpdateid() {
		return updateid;
	}
	/**
	 * @param updateid the updateid to set
	 */
	public void setUpdateid(Integer updateid) {
		this.updateid = updateid;
	}
	/**
	 * @return the updatetime
	 */
	public String getUpdatetime() {
		return updatetime;
	}
	/**
	 * @param updatetime the updatetime to set
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
		
}
