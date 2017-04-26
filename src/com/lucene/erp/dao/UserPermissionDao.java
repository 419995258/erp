package com.lucene.erp.dao;

import java.util.List;

import com.lucene.erp.domain.Permission;

//该接口定义User与其所对应的权限之间的关系的基本操作方法
public interface UserPermissionDao {
	// 定义一个用户-权限添加方法
	public abstract boolean insertUserPermission(final int id, String[] pid);

	// 定义一个获取用户对应权限的方法(该方法难度较大)
	public abstract List<Permission> getPermission(final int id);
}
