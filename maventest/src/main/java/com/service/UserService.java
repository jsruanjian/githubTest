package com.service;

import java.util.List;

import com.entity.User;



public interface UserService {

	//查询id
	   public User getUser(int id);
	   //查询所有user表
	   public List<User> getAllUser();
	   //添加user表
	   public void addUser(User user);
	   //删除一个id
	   public boolean delUser(int id);
	   //更新user表
	   public boolean updateUser(User user);
	   public List<User> login(String userName,String password);

	
}
