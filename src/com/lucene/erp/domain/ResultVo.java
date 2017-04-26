package com.lucene.erp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultVo {
	private List<Integer> msgids = new ArrayList<>();
	private boolean success; //是否操作成功
	private Map result = new HashMap(0); //返回对象
	private String message; //操作后提示信息
	
	private int userId;//登录id
	private String userName;//登录名
	private Date diyDate;//定制时间
	private String strDiyDate;//定制时间
	private String name;//店铺名
	private double money;//总收入
	
	
	
	
	public String getStrDiyDate() {
		return strDiyDate;
	}
	public void setStrDiyDate(String strDiyDate) {
		this.strDiyDate = strDiyDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
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
	public Date getDiyDate() {
		return diyDate;
	}
	public void setDiyDate(Date diyDate) {
		this.diyDate = diyDate;
	}
	public List<Integer> getMsgids() {
		return msgids;
	}
	public void setMsgids(List<Integer> msgids) {
		this.msgids = msgids;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map getResult() {
		return result;
	}
	public void setResult(Map result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	


}
