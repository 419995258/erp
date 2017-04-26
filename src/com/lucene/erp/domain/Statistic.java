package com.lucene.erp.domain;

import java.util.Date;

public class Statistic {
	/**
	 * 销售数量
	 */
	private int quantity;
	/**
	 * 成交金额
	 */
	private double billing;
	/**
	 * 收银人员
	 */
	private String cashier;
	/**
	 * 销售编号
	 */
	private int sid;
	/**
	 *成本 
	 */
	private double cost;
	/**
	 * 成交时间
	 */
	private Date diyDate;
	private String note;
	private int pid;
	private String userName;
	private int userId;
	
	private double saleMoney;//销售额
	private double imGet;//毛利润
	private double getpercent;//利润率
	private String strGetpercent;
	private String strSaleMoney;
	private String strImGet;
	
	private int saleNum;//销售数量
	private int customerNum;//会员数量
	
	
	
	
	
	
	
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	public double getGetpercent() {
		return getpercent;
	}
	public void setGetpercent(double getpercent) {
		this.getpercent = getpercent;
	}
	public String getStrGetpercent() {
		return strGetpercent;
	}
	public void setStrGetpercent(String strGetpercent) {
		this.strGetpercent = strGetpercent;
	}
	public String getStrSaleMoney() {
		return strSaleMoney;
	}
	public void setStrSaleMoney(String strSaleMoney) {
		this.strSaleMoney = strSaleMoney;
	}
	public String getStrImGet() {
		return strImGet;
	}
	public void setStrImGet(String strImGet) {
		this.strImGet = strImGet;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getBilling() {
		return billing;
	}
	public void setBilling(double billing) {
		this.billing = billing;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Date getDiyDate() {
		return diyDate;
	}
	public void setDiyDate(Date diyDate) {
		this.diyDate = diyDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(double saleMoney) {
		this.saleMoney = saleMoney;
	}
	public double getImGet() {
		return imGet;
	}
	public void setImGet(double imGet) {
		this.imGet = imGet;
	}
	public Statistic() {
		super();
	}
	
	
	
}
