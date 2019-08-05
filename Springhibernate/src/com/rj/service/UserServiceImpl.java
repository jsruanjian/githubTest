package com.rj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.dao.UserDao;
import com.rj.entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(int id) {
		
		return userDao.getUser(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public boolean delUser(int id) {
		
		return userDao.delUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> login(String userName, String password) {
		return userDao.login(userName, password);
	}

}
