package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.User;


@Repository
public class UserDaoImpl implements UserDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    
	@Override
	public User getUser(int id) {
		String hql="from User u where u.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (User) query.uniqueResult();
	}

	@Override
	public List<User> getAllUser() {
		String hql="from User ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);

	}

	@Override
	public boolean delUser(int id) {
		String hql="delete User u where u.id=?";
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean updateUser(User user) {
		 String hql="update User u set u.username=?, u.password=?,u.age=? where u.id=?";
		   Query query = sessionFactory.getCurrentSession().createQuery(hql);
		   query.setString(0, user.getUsername());
		   query.setString(1, user.getPassword());
		   query.setInteger(2, user.getAge());
		   query.setInteger(3, user.getId());
		   return (query.executeUpdate()>0);

	
	}

	@Override
	public List<User> login(String userName, String passWord) {
		String hql="from User u where u.username=? and u.password=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		query.setString(1, passWord);
		return query.list();

	}

}
