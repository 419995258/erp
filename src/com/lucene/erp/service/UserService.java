package com.lucene.erp.service;

import java.util.List;

import com.lucene.erp.domain.User;

public interface UserService {
	// 添加新用户
	public abstract boolean addUser(User user);

	// 检索所有用户
	public abstract List<User> findAllUsers();

	// 根据用户id检索用户
	public abstract User findUserByID(final int id);

	// 用户系统登录校验
	public abstract boolean login(User user);
	
	// 查看用户当前状态（开启与禁用）
	public abstract int getStatus(User user);
}
