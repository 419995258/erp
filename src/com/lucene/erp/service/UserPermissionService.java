package com.lucene.erp.service;

import java.util.List;

import com.lucene.erp.domain.Permission;

public interface UserPermissionService {
	// 定义一个用户-权限添加方法
	public abstract boolean addUserPermission(final int id, String[] pid);

	// 定义一个获取用户对应权限的方法(该方法难度较大)
	public abstract List<Permission> getPermission(final int id);
}
