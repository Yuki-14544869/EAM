package com.heu.eam.dao.pojo;

public class Item {
	private Integer id;
	private String name;
	private double price;
	private Integer placeId;
	private Integer deptId;
	private Integer testId;
	private String buyerName;
	private Integer provId;
	private Integer typeId;
	private String enterDate;
	private String del;
	private Integer createId;
	private String createtime;
	private Integer updateId;
	private String updatetime;
	private Integer version;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String name, double price, Integer placeId, Integer deptId,
			Integer testId, String buyerName, Integer provId, Integer typeId,
			String enterDate) {
		super();
		this.name = name;
		this.price = price;
		this.placeId = placeId;
		this.deptId = deptId;
		this.testId = testId;
		this.buyerName = buyerName;
		this.provId = provId;
		this.typeId = typeId;
		this.enterDate = enterDate;
	}

	public Item(String name,double price, String buyerName, String enterDate) {
		this.name = name;
		this.price = price;
		this.buyerName = buyerName;
		this.enterDate = enterDate;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the placeId
	 */
	public Integer getPlaceId() {
		return placeId;
	}

	/**
	 * @param placeId
	 *            the placeId to set
	 */
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	/**
	 * @return the deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId
	 *            the deptId to set
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the testId
	 */
	public Integer getTestId() {
		return testId;
	}

	/**
	 * @param testId
	 *            the testId to set
	 */
	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}

	/**
	 * @param buyerName
	 *            the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	/**
	 * @return the provId
	 */
	public Integer getProvId() {
		return provId;
	}

	/**
	 * @param provId
	 *            the provId to set
	 */
	public void setProvId(Integer provId) {
		this.provId = provId;
	}

	/**
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId
	 *            the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the enterDate
	 */
	public String getEnterDate() {
		return enterDate;
	}

	/**
	 * @param enterDate
	 *            the enterDate to set
	 */
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
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
	 * @return the updateId
	 */
	public Integer getUpdateId() {
		return updateId;
	}

	/**
	 * @param updateId the updateId to set
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
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
