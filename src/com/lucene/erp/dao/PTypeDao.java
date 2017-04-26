package com.lucene.erp.dao;

import java.util.List;

import com.lucene.erp.domain.PType;
import com.lucene.erp.domain.Permission;

public interface PTypeDao {
	public abstract boolean insertPType(PType type);// 定义一个添加权限类型的方法

	public abstract List<PType> selectAllPTypes();// 定义一个查询所有权限类型的方法
	
	// 该方法将权限进行归类，以返回所有权限类型（权限类型里可以调用get方法获取所属权限）
	public abstract List<PType> getPTypeList(List<Permission> permissionList);
}
