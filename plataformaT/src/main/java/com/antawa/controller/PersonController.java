package com.antawa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.antawa.model.Person;
import com.antawa.services.impl.PersonServiceImpl;
import com.antawa.util.CustomErrorType;

@RestController
@RequestMapping("api")
public class PersonController {

	public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	/**
	 * Service of User.
	 */
	@Autowired
	private PersonServiceImpl personService;

	/**
	 * request method to create a new account by a guest.
	 * 
	 * @param newUser
	 * @param type
	 * @return
	 */
	// request method to create a new account by a guest
		@CrossOrigin
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ResponseEntity<?> createPerson(@RequestBody Person newPerson) {
			if (personService.find(newPerson.getCedula()) != null) {
				logger.error("Identification Already exist " + newPerson.getCedula());
				return new ResponseEntity(
						new CustomErrorType("Person with Identification " + newPerson.getCedula() + "already exist "),
						HttpStatus.CONFLICT);
			}
			
			return new ResponseEntity<Person>(personService.save(newPerson), HttpStatus.CREATED);
	}
}
