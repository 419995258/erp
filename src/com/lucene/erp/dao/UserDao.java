package com.lucene.erp.dao;

import java.util.List;
import java.util.Map;

import com.lucene.erp.domain.Sale;
import com.lucene.erp.domain.User;

//该接口定义用户的基本操作方法
public interface UserDao {
	// 添加新用户
	public abstract boolean insertUser(User user);

	// 检索所有用户
	public abstract List<User> selectAllUsers();

	// 根据用户id检索用户
	public abstract User selectUserByID(int id);

	// 用户系统登录校验
	public abstract User login(User user);

	// 查看用户当前状态（开启与禁用）
	public abstract int getStatus(User user);

	// 查看用户当前身份

	public abstract User getType(User user);

	// 查询所有
	public List<User> getPagingList(int start, int number, Map<String, Object> searchItem);

	public abstract int getCount() throws Exception;
	
	
	//更新用户
	public abstract int updateUser(User user)throws Exception;
}
