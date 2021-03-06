package com.lucene.erp.domain;

import java.util.List;

//权限类型实体类
public class PType {
	private int id;// 权限类型表主键
	private String name;// 权限名称
	private String description;// 权限描述
	private List<Permission> permissionList;// 权限类型所对应的权限集合

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public PType() {
	}

	public PType(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "PType [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
