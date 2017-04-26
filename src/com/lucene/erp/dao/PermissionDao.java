package com.lucene.erp.dao;

import java.util.List;

import com.lucene.erp.domain.Permission;

//该接口定义有关权限的基本操作方法
public interface PermissionDao {
	public abstract boolean insertPermission(Permission permission);// 添加权限

	public abstract List<Permission> selectAllPermissions();// 检索所有权限

	public abstract List<Permission> selectPermissionByPtid(final int ptid);// 根据权限类型来检索对应的权限集合

	public abstract Permission selectPermissionByID(final int id);// 根据权限id检索权限信息
}
