package com.lucene.erp.domain;

import java.util.Date;

public class SaleVo {
	private int pid;
	private String diyNum;
	private String name ;
	private String tel;
	private Date diyDate ;
	private String deliverDate;
	private double weight ;
	private String subStone;
	private String mainStone ;
	private double goldCost;
	private double handCost ;
	private int quantity;
	private double cost;
	private double billing;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDiyNum() {
		return diyNum;
	}
	public void setDiyNum(String diyNum) {
		this.diyNum = diyNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDiyDate() {
		return diyDate;
	}
	public void setDiyDate(Date diyDate) {
		this.diyDate = diyDate;
	}
	public String getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getSubStone() {
		return subStone;
	}
	public void setSubStone(String subStone) {
		this.subStone = subStone;
	}
	public String getMainStone() {
		return mainStone;
	}
	public void setMainStone(String mainStone) {
		this.mainStone = mainStone;
	}
	public double getGoldCost() {
		return goldCost;
	}
	public void setGoldCost(double goldCost) {
		this.goldCost = goldCost;
	}
	public double getHandCost() {
		return handCost;
	}
	public void setHandCost(double handCost) {
		this.handCost = handCost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getBilling() {
		return billing;
	}
	public void setBilling(double billing) {
		this.billing = billing;
	}
	
	
}
