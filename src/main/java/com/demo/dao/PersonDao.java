package com.demo.dao;

import com.demo.entity.Person;

import java.util.List;

public interface PersonDao {
	public void regist(Person person);
	public Person login(String username, String password);
	public List<Person> getPerson();
}
