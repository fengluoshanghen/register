package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
/*import org.springframework.orm.hibernate3.support.HibernateDaoSupport;*/

import com.demo.entity.Person;

public class PersonDaoImpl  implements PersonDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void regist(Person person) {
		//getHibernateTemplate().save(person);
		sessionFactory.getCurrentSession().save(person);
	}
	@Override
	public List<Person> getPerson(){
		String hql = "select userName from Person";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public Person login(String username,String password) {

		String hql="from Person p where p.userName=:name and p.userPassword= :pwd";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("name", username);
		query.setString("pwd", password);
		List<Person> list=query.list();
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
