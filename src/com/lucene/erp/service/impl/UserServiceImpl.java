package com.lucene.erp.service.impl;

import java.util.List;

import com.lucene.erp.dao.UserDao;
import com.lucene.erp.dao.impl.UserDaoImpl;
import com.lucene.erp.domain.User;
import com.lucene.erp.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		
		String username = user.getUsername();
		String pwd = user.getPwd();
		user = new User(username, pwd);
		/*user.setUsername(username);
		user.setPwd(pwd);*/
		UserDao userDao = new UserDaoImpl();
		//boolean rs = userDao.login(user);
		return false;
	}

	@Override
	public int getStatus(User user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		
		return userDao.getStatus(user);
	}

}
