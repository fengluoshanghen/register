package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.demo.entity.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User getUser(Integer id) {
		/*
		String hql = "from User u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (User)query.uniqueResult();*///
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> getAllUser(int pageSize,int pageNumber) {
		
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public List<User> getAllUser(int pageSize,int pageNumber,String name) {

		String hql = "from User where userName like '%"+name+"%'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public int getCount(){
		int count = 0;
		String hql = "select count(*) from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List list = query.list();
		count = Integer.parseInt(String.valueOf(list.get(0)));
		return count;
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public boolean delUser(Integer id) {
		
		String hql = "delete User u where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateUser(User user) {
		
		String hql = "update User u set u.userName = ?,u.age=? where u.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getAge());
		query.setInteger(2, user.getId());
		
		return (query.executeUpdate() > 0);
	}

}
