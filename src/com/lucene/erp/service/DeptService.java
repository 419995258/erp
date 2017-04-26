package com.lucene.erp.service;

import java.util.List;

import com.lucene.erp.domain.Dept;

public interface DeptService {
	// 添加部门信息
	public abstract boolean addDept(Dept dept);

	// 查询所有部门信息
	public abstract List<Dept> findAllDepts();
}
