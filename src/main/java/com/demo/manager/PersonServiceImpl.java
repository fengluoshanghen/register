package com.demo.manager;

import com.demo.dao.PersonDao;
import com.demo.entity.Person;

import java.util.List;

public class PersonServiceImpl implements PersonService {
	private PersonDao personDao;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void regist(Person person) {
		personDao.regist(person);
	}

	@Override
	public Person login(String username,String password) {
		
		return personDao.login(username,password);
	}

	@Override
	public List<Person> getPerson(){
		return personDao.getPerson();
	}
	
}
