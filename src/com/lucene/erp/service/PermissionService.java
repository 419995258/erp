package com.lucene.erp.service;

import java.util.List;

import com.lucene.erp.domain.Permission;

public interface PermissionService {
	// 添加权限
	public abstract boolean addPermission(Permission permission);

	// 检索所有权限
	public abstract List<Permission> findAllPermissions();

	// 根据权限类型来检索对应的权限集合
	public abstract List<Permission> findPermissionByPtid(final int ptid);

	// 根据权限id检索权限信息
	public abstract Permission findPermissionByID(final int id);
}
