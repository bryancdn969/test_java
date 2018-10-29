package com.antawa.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.antawa.model.User;
import com.antawa.services.impl.UserService;
import com.antawa.util.CustomErrorType;


@RestController
@RequestMapping("account")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	/**
	 * Service of User.
	 */
	@Autowired
	private UserService userService;

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
		public ResponseEntity<?> createUser(@RequestBody User newUser) {
			if (userService.find(newUser.getUsername()) != null) {
				logger.error("username Already exist " + newUser.getUsername());
				return new ResponseEntity(
						new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
						HttpStatus.CONFLICT);
			}
			newUser.setRole("USER");
			
			return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}

	// this is the login api/service

	/**
	 * 
	 * @param principal
	 * @return
	 */
	// this is the login api/service
		@CrossOrigin
		@RequestMapping("/login")
		public Principal user(Principal principal) {
			
			logger.info("user logged "+principal);
			return principal;
	}



	/**
	 * 
	 * @param session
	 */
	// @CrossOrigin
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout(HttpSession session) {

		if (session != null) {
			logger.info("Cerrando session " + session);
			System.out.println("Cerrando session............................................");
			session.invalidate();
		}
	}

}
