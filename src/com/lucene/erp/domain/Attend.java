package com.lucene.erp.domain;

import java.util.Date;

public class Attend {
	private int id;
	private String name;
	private Date nowdate;
	private String attendday;
	private String passday;
	private String restday;
	private String sickday;
	private String leaveday;
	private String allday;
	private String lateday;
	private String inday;
	private String overday;
	private String leader;
	private String surer;
	private String note;
	private int userId;
	private String userName;
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
	public Date getNowdate() {
		return nowdate;
	}
	public void setNowdate(Date nowdate) {
		this.nowdate = nowdate;
	}
	public String getAttendday() {
		return attendday;
	}
	public void setAttendday(String attendday) {
		this.attendday = attendday;
	}
	public String getPassday() {
		return passday;
	}
	public void setPassday(String passday) {
		this.passday = passday;
	}
	public String getRestday() {
		return restday;
	}
	public void setRestday(String restday) {
		this.restday = restday;
	}
	public String getSickday() {
		return sickday;
	}
	public void setSickday(String sickday) {
		this.sickday = sickday;
	}
	public String getLeaveday() {
		return leaveday;
	}
	public void setLeaveday(String leaveday) {
		this.leaveday = leaveday;
	}
	public String getAllday() {
		return allday;
	}
	public void setAllday(String allday) {
		this.allday = allday;
	}
	public String getLateday() {
		return lateday;
	}
	public void setLateday(String lateday) {
		this.lateday = lateday;
	}
	public String getInday() {
		return inday;
	}
	public void setInday(String inday) {
		this.inday = inday;
	}
	public String getOverday() {
		return overday;
	}
	public void setOverday(String overday) {
		this.overday = overday;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getSurer() {
		return surer;
	}
	public void setSurer(String surer) {
		this.surer = surer;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public Attend(String name, Date nowdate, String attendday, String passday, String restday, String sickday,
			String leaveday, String allday, String lateday, String inday, String overday, String leader, String surer,
			String note, int userId, String userName) {
		super();
		this.name = name;
		this.nowdate = nowdate;
		this.attendday = attendday;
		this.passday = passday;
		this.restday = restday;
		this.sickday = sickday;
		this.leaveday = leaveday;
		this.allday = allday;
		this.lateday = lateday;
		this.inday = inday;
		this.overday = overday;
		this.leader = leader;
		this.surer = surer;
		this.note = note;
		this.userId = userId;
		this.userName = userName;
	}
	public Attend() {
		super();
	}
	
	
	
	
}
