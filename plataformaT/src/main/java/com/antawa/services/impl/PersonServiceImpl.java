package com.antawa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antawa.model.Person;
import com.antawa.model.repository.PersonRepository;

@Service
public class PersonServiceImpl{

	@Autowired
	PersonRepository personRepository;
	
	public Person save(Person person) {
		return personRepository.saveAndFlush(person);
	}

	public Person update(Person person) {
		return personRepository.save(person);
	}
	
	public Person find(String cedula) {
		return personRepository.findOneByCedula(cedula);
	}

	public Person find(Long id) {
		return personRepository.findOne(id);
	}
}
