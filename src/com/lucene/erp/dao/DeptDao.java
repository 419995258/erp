package com.lucene.erp.dao;

import java.util.List;

import com.lucene.erp.domain.Dept;

//该接口主要定义有关Dept的基本操作
public interface DeptDao {
	// 接口中的方法默认被定义为：public abstract，变量被定义为public static final
	public abstract boolean insertDept(Dept dept);

	// 声明获取所有部门信息的方法
	public abstract List<Dept> selectAllDepts();

	// 声明根据部门id获取部门信息的方法
	public abstract Dept selectDeptByID(final int id);

	// 声明根据部门名称获取部门信息的方法
	public abstract Dept selectDeptByName(String name);

	// 声明修改部门信息的方法
	public abstract boolean updateDept(Dept dept);
}
