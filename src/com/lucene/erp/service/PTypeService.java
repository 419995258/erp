package com.lucene.erp.service;

import java.util.List;

import com.lucene.erp.domain.PType;
import com.lucene.erp.domain.Permission;

public interface PTypeService {
	// 添加权限类型
	public abstract boolean addPType(PType pType);

	// 检索所有权限类型
	public abstract List<PType> findAllPTypes();

	// 对用户所有权限进行归类封装
	public abstract List<PType> getPTypeList(List<Permission> permissionList);
}
