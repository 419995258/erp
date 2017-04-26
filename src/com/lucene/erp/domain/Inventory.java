package com.lucene.erp.domain;

import java.util.Date;

//商品盘点信息实体类：该实体类的存库差异信息可以通过计算得出，因此无需作为实体信息（数据表也不用建立该字段）
public class Inventory {
	private int id;// 主键
	private int pid;// 商品id
	private String name;
	private String superPlatPeople;// 监盘人
	private String inventoryPeople;// 盘点人
	private Date inventoryTime;// 盘点时间
	private int quantity;// 系统库存
	private int inventoryStock;// 盘点库存
	private int changeStock; //盘点差异
	private String note;//备注
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSuperPlatPeople() {
		return superPlatPeople;
	}
	public void setSuperPlatPeople(String superPlatPeople) {
		this.superPlatPeople = superPlatPeople;
	}
	public String getInventoryPeople() {
		return inventoryPeople;
	}
	public void setInventoryPeople(String inventoryPeople) {
		this.inventoryPeople = inventoryPeople;
	}
	public Date getInventoryTime() {
		return inventoryTime;
	}
	public void setInventoryTime(Date inventoryTime) {
		this.inventoryTime = inventoryTime;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getInventoryStock() {
		return inventoryStock;
	}
	public void setInventoryStock(int inventoryStock) {
		this.inventoryStock = inventoryStock;
	}
	public int getChangeStock() {
		return changeStock;
	}
	public void setChangeStock(int changeStock) {
		this.changeStock = changeStock;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Inventory() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Inventory(int pid, String superPlatPeople, String inventoryPeople, Date inventoryTime, int inventoryStock,
			String note) {
		super();
		this.pid = pid;
		this.superPlatPeople = superPlatPeople;
		this.inventoryPeople = inventoryPeople;
		this.inventoryTime = inventoryTime;
		this.inventoryStock = inventoryStock;
		this.note = note;
	}
	

	

}
