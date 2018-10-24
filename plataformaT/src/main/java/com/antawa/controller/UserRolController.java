package com.antawa.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antawa.util.ResponseObject;
import com.antawa.model.UserAuth;
import com.antawa.services.UserAuthRolService;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@RestController
@RequestMapping("access")
public class UserRolController {

	/**
	 * Service of UserProfile.
	 */
	@Autowired
	private UserAuthRolService userRolProfileService;

	/**
	 * 
	 * @param principal
	 * @return
	 */
//	@RequestMapping(value ="/login", method = RequestMethod.GET)
//	public ResponseObject<UserAuth> login(String username, Principal principal) {
//		ResponseObject<UserAuth> response = new ResponseObject<>();
//		System.out.println("login: " + username);
//		if (principal instanceof UsernamePasswordAuthenticationToken) {
//			UsernamePasswordAuthenticationToken usr = (UsernamePasswordAuthenticationToken) principal;
//			UserAuth user = ((UserAuth) usr.getPrincipal());
//			try {
//				System.out.println("Buscando ");
//				UserAuth up = userRolProfileService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
//				response.setResponse(up);
//			} catch (Exception e) {
//				response.setStatus(HttpStatus.CONFLICT);
//				response.setMessage("Perfil no se pudo crear");
//			}
//			String userName = ((UserAuth) usr.getPrincipal()).getUserName();
//			System.out.println("SI: " + userName);
//		} else {
//			String userName = principal.toString();
//			System.out.println("NO" + userName);
//		}
//
//		return response;
//	}
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public ResponseObject<UserAuth> login(String username) {
		ResponseObject<UserAuth> response = new ResponseObject<>();
		
		UserAuth user = new UserAuth();
		try {
			System.out.println("Buscando ");
			UserAuth up = userRolProfileService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
			//UserAuth up = userRolProfileService.find(user.getUserName());	
			response.setResponse(up);
		} catch (Exception e) {
			response.setStatus(HttpStatus.CONFLICT);
		}
		
		return response;
}
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ResponseObject<?> find(@RequestBody UserAuth user) {
//		ResponseObject<UserAuth> resp = new ResponseObject<>();
//		
//		try {
//			UserAuth users = userRolProfileService.find(user.getUserName());
//			resp.setResponse(users);
//			return resp;
//		} catch (Exception e) {
//			resp.setResponse(null);
//			resp.setStatus(HttpStatus.CONFLICT);
//			resp.setMessage("ERROR obt objs");
//			return resp;
//		}
//		
//	}
	
}
