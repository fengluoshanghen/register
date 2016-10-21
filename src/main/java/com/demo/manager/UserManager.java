package com.demo.manager;

import java.util.List;

import com.demo.entity.User;

public interface UserManager {

	public User getUser(Integer id);
	
	public List<User> getAllUser(int pageSize,int pageNumber);

	public List<User> getAllUser(int pageSize,int pageNumber,String name);

	public int getCount();
	
	public void addUser(User user);
	
	public boolean delUser(Integer id);
	
	public boolean updateUser(User user);
}
