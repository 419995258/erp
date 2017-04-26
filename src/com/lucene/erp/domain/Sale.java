package com.lucene.erp.domain;

import java.util.Date;

//销售信息实体类：包括商品信息、客户信息和销售本身相关信息
public class Sale {
	private int id;// 主键
	private int sid;// 销售编号
	private String diyNum;// 定制单号
	private Date diyDate;// 定制日期
	private Date deliverDate;// 交货日期
	private int quantity;// 销售数量
	private double retaPrice;// 零售价
	private double deposit;// 定金
	private double billing;// 结算
	private String cashier;// 收银员
	private String diyConsultant;// 定制顾问：销售顾问
	private String customerArchive;// 顾客建档：这里应该是上传文档的链接地址
	private int pid;// 商品表主键
	private int cid;// 客户表主键
	private String note;// 备注
	private String customerArchiveName;// 顾客建档：这里应该是上传文档的名字
	private Customer customer;
	private Product product;
	
	private int userId;
	private String userName;
	
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getDiyNum() {
		return diyNum;
	}

	public void setDiyNum(String diyNum) {
		this.diyNum = diyNum;
	}

	public Date getDiyDate() {
		return diyDate;
	}

	public void setDiyDate(Date diyDate) {
		this.diyDate = diyDate;
	}

	public Date getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
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

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
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

	public String getDiyConsultant() {
		return diyConsultant;
	}

	public void setDiyConsultant(String diyConsultant) {
		this.diyConsultant = diyConsultant;
	}

	public String getCustomerArchive() {
		return customerArchive;
	}

	public void setCustomerArchive(String customerArchive) {
		this.customerArchive = customerArchive;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

	
	public String getCustomerArchiveName() {
		return customerArchiveName;
	}

	public void setCustomerArchiveName(String customerArchiveName) {
		this.customerArchiveName = customerArchiveName;
	}

	public Sale() {
	}

	public Sale(int id, int sid, String diyNum, Date diyDate, Date deliverDate, int quantity, double retaPrice,
			double deposit, double billing, String cashier, String diyConsultant, String customerArchive, int pid,
			int cid, String note) {
		this.id = id;
		this.sid = sid;
		this.diyNum = diyNum;
		this.diyDate = diyDate;
		this.deliverDate = deliverDate;
		this.quantity = quantity;
		this.retaPrice = retaPrice;
		this.deposit = deposit;
		this.billing = billing;
		this.cashier = cashier;
		this.diyConsultant = diyConsultant;
		this.customerArchive = customerArchive;
		this.pid = pid;
		this.cid = cid;
		this.note = note;
	}
	
	

	
	public Sale(int sid, String diyNum, Date diyDate, Date deliverDate, int quantity, double retaPrice,
			double deposit, double billing, String cashier, String diyConsultant, String customerArchive, int pid,
			int cid, String note, String customerArchiveName) {
		super();
		this.sid = sid;
		this.diyNum = diyNum;
		this.diyDate = diyDate;
		this.deliverDate = deliverDate;
		this.quantity = quantity;
		this.retaPrice = retaPrice;
		this.deposit = deposit;
		this.billing = billing;
		this.cashier = cashier;
		this.diyConsultant = diyConsultant;
		this.customerArchive = customerArchive;
		this.pid = pid;
		this.cid = cid;
		this.note = note;
		this.customerArchiveName = customerArchiveName;
	}

	
	public Sale(int id, String diyNum, Date diyDate, Date deliverDate, int quantity, double retaPrice, double deposit,
			double billing, String cashier, String diyConsultant, String note) {
		super();
		this.id = id;
		this.diyNum = diyNum;
		this.diyDate = diyDate;
		this.deliverDate = deliverDate;
		this.quantity = quantity;
		this.retaPrice = retaPrice;
		this.deposit = deposit;
		this.billing = billing;
		this.cashier = cashier;
		this.diyConsultant = diyConsultant;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", sid=" + sid + ", diyNum=" + diyNum + ", diyDate=" + diyDate + ", deliverDate="
				+ deliverDate + ", quantity=" + quantity + ", retaPrice=" + retaPrice + ", deposit=" + deposit
				+ ", billing=" + billing + ", cashier=" + cashier + ", diyConsultant=" + diyConsultant
				+ ", customerArchive=" + customerArchive + ", pid=" + pid + ", cid=" + cid + ", note=" + note + "]";
	}

}
