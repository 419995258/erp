package com.lucene.erp.domain;

import java.io.Serializable;
import java.util.Date;

//客户实体类：即会员实体
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID =  -4243357488988840130L;
	private int id;// 主键
	private int cid;// 客户编号
	private String name;// 客户姓名
	private String tel;// 联系电话
	private Date birthday;// 客户生日
	private String address;// 客户地址
	private String email;// 客户电邮
	private double saleAmount;// 购买金额
	private String record;// 回访记录
	private String note;// 备注
	private String firService;//第一次维护
	private String secService;
	private String thrService;
	private String fouService;
	private String serviceLeader;//维护负责人
	
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getServiceLeader() {
		return serviceLeader;
	}

	public void setServiceLeader(String serviceLeader) {
		this.serviceLeader = serviceLeader;
	}

	public String getFirService() {
		return firService;
	}

	public void setFirService(String firService) {
		this.firService = firService;
	}

	public String getSecService() {
		return secService;
	}

	public void setSecService(String secService) {
		this.secService = secService;
	}

	public String getThrService() {
		return thrService;
	}

	public void setThrService(String thrService) {
		this.thrService = thrService;
	}

	public String getFouService() {
		return fouService;
	}

	public void setFouService(String fouService) {
		this.fouService = fouService;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Customer() {
	}

	public Customer(int id, int cid, String name, String tel, Date birthday, String address, String email,
			double saleAmount, String record, String note) {
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.saleAmount = saleAmount;
		this.record = record;
		this.note = note;
	}

	public Customer(int id, String name, String tel, Date birthday, String address, String email, double saleAmount,
			String record, String note) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.saleAmount = saleAmount;
		this.record = record;
		this.note = note;
	}

	public Customer(int id, String name, String tel, Date birthday, String address, String email, double saleAmount,
			String record, String note, String firService, String secService, String thrService, String fouService,
			String serviceLeader) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.saleAmount = saleAmount;
		this.record = record;
		this.note = note;
		this.firService = firService;
		this.secService = secService;
		this.thrService = thrService;
		this.fouService = fouService;
		this.serviceLeader = serviceLeader;
	}

	public Customer(int id, int cid, String name, String tel, Date birthday, String address, String email,
			double saleAmount, String record, String note, String firService, String secService, String thrService,
			String fouService, String serviceLeader) {
		super();
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.saleAmount = saleAmount;
		this.record = record;
		this.note = note;
		this.firService = firService;
		this.secService = secService;
		this.thrService = thrService;
		this.fouService = fouService;
		this.serviceLeader = serviceLeader;
	}

	
	public Customer(int id, String note, String firService, String secService, String thrService,
			String fouService, String serviceLeader) {
		super();
		this.id = id;
		this.note = note;
		this.firService = firService;
		this.secService = secService;
		this.thrService = thrService;
		this.fouService = fouService;
		this.serviceLeader = serviceLeader;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", cid=" + cid + ", name=" + name + ", tel=" + tel + ", birthday=" + birthday
				+ ", address=" + address + ", email=" + email + ", saleAmount=" + saleAmount + ", record=" + record
				+ ", note=" + note + "]";
	}

}
