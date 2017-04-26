package com.lucene.erp.domain;

//部门实体类：包含店铺
public class Dept {
	private int id;// 部门表主键
	private String deptName;// 部门名称
	private String address;// 部门地址

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Dept() {
	}

	public Dept(int id, String deptName, String address) {
		this.id = id;
		this.deptName = deptName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", deptName=" + deptName + ", address=" + address + "]";
	}

}
