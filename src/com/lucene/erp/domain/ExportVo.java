package com.lucene.erp.domain;

import java.util.Date;

//出库信息实体类
public class ExportVo {
	private String receiveDept;// 签收部门
	private String receiver;// 签收人
	private Date receiveTime;// 签收时间
	private int quantity;// 出库数量
	private double retaPrice;// 零售价
	private String note;// 备注
	private int pid;// 商品表主键
	private double allMoney;//总价
	private String name;
	private String size;
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(double allMoney) {
		this.allMoney = allMoney;
	}

	
	
	public String getReceiveDept() {
		return receiveDept;
	}

	public void setReceiveDept(String receiveDept) {
		this.receiveDept = receiveDept;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRetaPrice() {
		return retaPrice;
	}

	public void setRetaPrice(double retaPrice) {
		this.retaPrice = retaPrice;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public ExportVo() {
	}

	public ExportVo(String receiveDept, String receiver, Date receiveTime, int quantity, double retaPrice, String note,
			int pid, double allMoney, String name, String size) {
		super();
		this.receiveDept = receiveDept;
		this.receiver = receiver;
		this.receiveTime = receiveTime;
		this.quantity = quantity;
		this.retaPrice = retaPrice;
		this.note = note;
		this.pid = pid;
		this.allMoney = allMoney;
		this.name = name;
		this.size = size;
	}

	


	
	
	

	
	
}
