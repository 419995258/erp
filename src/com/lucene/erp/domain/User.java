package com.lucene.erp.domain;

//用户实体类：用户就是使用该软件的操作者
public class User {
	private int id;// 用户表主键
	private String username;// 用户名称
	private String pwd;// 用户口令
	private String mobile;// 联系电话
	private int deptID;// 部门主键
	private int status;// 用户状态：不删除用户信息，设置开启与禁用
	private int type;
	private String name;
	private String typeName;
	private String statusName;
	
	
	
	
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User() {
	}

	public User(int id, String username, String pwd, String mobile, int deptID, int status) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.mobile = mobile;
		this.deptID = deptID;
		this.status = status;
	}

	public User(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ",mobile= " + mobile + ", deptID="
				+ deptID + ", status=" + status + "]";
	}

	public User(String username, String pwd, int type, String name) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.type = type;
		this.name = name;
	}

	public User(int id,String pwd, int status, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.status = status;
		this.name = name;
	}

	
	
	
	

	
	
	
}
