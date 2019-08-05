package com.rj.dao;

import java.util.List;

import com.rj.entity.User;



public interface UserDao {

	public User getUser(int id);
	public List<User> getAllUser();
	public void addUser(User user);
	public boolean delUser(int id);
	public boolean updateUser(User user);
	public List<User> login(String userName,String passWord);
}
