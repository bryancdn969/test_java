package com.antawa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antawa.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	public Person findOneByCedula(String cedula);

}
