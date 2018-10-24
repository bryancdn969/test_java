package com.antawa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antawa.model.UserAuth;
import com.antawa.model.repository.UserAuthRepository;
import com.antawa.services.UserAuthRolService;

@Service
public class UserAuthRolServiceImpl implements UserAuthRolService{
	
	/**
	 * Repository of User.
	 */
	@Autowired
	private UserAuthRepository userRolRepository;

//	@Override
//	public UserAuth_Rol findByUserIdAndRolId(Long userauth_id, Long rol_id) throws ServiceException {
//		return userRolRepository.findByUserIdAndRolId(userauth_id, rol_id);
//	}
	
	@Override
	public UserAuth findByUserNameAndPassword(String username, String password) {
		return userRolRepository.findByUserNameAndPassword(username, password);
	}
	

}
