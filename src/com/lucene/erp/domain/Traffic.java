package com.lucene.erp.domain;

import java.util.Date;

public class Traffic {
	private int id;
	private String innum;
	private Date intime;
	private Date outtime;
	private String type;
	private String age;
	private int pid;
	private String reason;
	private String diyConsultant;
	private String note;
	private int userId;
	private String userName;
	public String getInnum() {
		return innum;
	}
	public void setInnum(String innum) {
		this.innum = innum;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public Date getOuttime() {
		return outtime;
	}
	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDiyConsultant() {
		return diyConsultant;
	}
	public void setDiyConsultant(String diyConsultant) {
		this.diyConsultant = diyConsultant;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Traffic() {
		super();
	}
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
	public Traffic(String innum, Date intime, Date outtime, String type, String age, int pid, String reason,
			String diyConsultant, String note, int userId, String userName) {
		super();
		this.innum = innum;
		this.intime = intime;
		this.outtime = outtime;
		this.type = type;
		this.age = age;
		this.pid = pid;
		this.reason = reason;
		this.diyConsultant = diyConsultant;
		this.note = note;
		this.userId = userId;
		this.userName = userName;
	}
	
	
	
}
