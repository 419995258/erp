package com.lucene.erp.domain;

//权限实体类
public class Permission {
	private int id;// 主键
	private String name;// 权限名称
	private String links;// 权限连接地址
	private int ptid;// 权限类型表主键

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

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	public Permission() {
	}

	public Permission(int id, String name, String links, int ptid) {
		this.id = id;
		this.name = name;
		this.links = links;
		this.ptid = ptid;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", links=" + links + ", ptid=" + ptid + "]";
	}

}
