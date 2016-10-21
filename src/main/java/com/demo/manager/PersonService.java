package com.demo.manager;

import com.demo.entity.Person;

import java.util.List;

public interface PersonService {
	public void regist(Person person);
	public Person login(String username, String password);
	public List<Person> getPerson();
}
