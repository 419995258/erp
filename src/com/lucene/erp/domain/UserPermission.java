package com.lucene.erp.domain;

//用户权限对应关系实体类：描述用户与权限的对应关系
public class UserPermission {
	private int id;// 主键
	private int uid;// 用户表主键
	private int pid;// 权限表主键

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public UserPermission() {
	}

	public UserPermission(int id, int uid, int pid) {
		this.id = id;
		this.uid = uid;
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "UserPermission [id=" + id + ", uid=" + uid + ", pid=" + pid + "]";
	}

}
