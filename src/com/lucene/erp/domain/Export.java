package com.lucene.erp.domain;

import java.util.Date;

//出库信息实体类
public class Export {
	private int id;// 主键
	private String barCode;// 条形码：出库编号
	private String receiveDept;// 签收部门
	private String receiver;// 签收人
	private Date receiveTime;// 签收时间
	private int quantity;// 出库数量
	private double retaPrice;// 零售价
	private String note;// 备注
	private int pid;// 商品表主键
	private Product product;
	private double allMoney;//总价
	
	
	
	public double getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(double allMoney) {
		this.allMoney = allMoney;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Export() {
	}

	public Export(int id, String barCode, String receiveDept, String receiver, Date receiveTime, int quantity,
			double retaPrice, int pid, String note) {
		this.id = id;
		this.barCode = barCode;
		this.receiveDept = receiveDept;
		this.receiver = receiver;
		this.receiveTime = receiveTime;
		this.quantity = quantity;
		this.retaPrice = retaPrice;
		this.pid = pid;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Export [id=" + id + ", barCode=" + barCode + ", receiveDept="
				+ receiveDept + ", receiver=" + receiver + ", receiveTime="
				+ receiveTime + ", quantity=" + quantity + ", retaPrice="
				+ retaPrice + ", note=" + note + ", pid=" + pid + ", product="
				+ product.toString() + "]";
	}

	public Export(String barCode, String receiveDept, String receiver, Date receiveTime, int quantity, double retaPrice,
			String note, int pid) {
		super();
		this.barCode = barCode;
		this.receiveDept = receiveDept;
		this.receiver = receiver;
		this.receiveTime = receiveTime;
		this.quantity = quantity;
		this.retaPrice = retaPrice;
		this.note = note;
		this.pid = pid;
	}

	/*@Override
	public String toString() {
		return "Export [id=" + id + ", barCode=" + barCode + ", receiveDept=" + receiveDept + ", receiver=" + receiver
				+ ", receiveTime=" + receiveTime + ", quantity=" + quantity + ", retaPrice=" + retaPrice + ", pid="
				+ pid + ", note=" + note + "]";
	}*/
	
	
	
	

	
	
}
