package com.demo.manager;

import java.util.List;

import com.demo.dao.UserDao;
import com.demo.entity.User;

public class UserManagerImpl implements UserManager {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUser(int pageSize,int pageNumber) {
		return userDao.getAllUser(pageSize,pageNumber);
	}

	@Override
	public List<User> getAllUser(int pageSize,int pageNumber,String name) {
		return userDao.getAllUser(pageSize,pageNumber,name);
	}

	@Override
	public int getCount() {
		return userDao.getCount();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public boolean delUser(Integer id) {
		
		return userDao.delUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

}
