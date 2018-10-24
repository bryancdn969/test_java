package com.antawa.services;

import com.antawa.model.UserAuth;

public interface UserAuthRolService {
	
	
	/**
	 * this method find an user by username.
	 * 
	 * @param userName
	 * @return
	 */
	UserAuth findByUserNameAndPassword(String userName, String password);
	//UserAuth find(String userName);
	
	/**
	 * this method find an user by rol.
	 * 
	 * @param userName
	 * @return
	 */
	//Rol findByRol(String rol);
	
	/**
	 * 
	 * @param userauth_id
	 * @param rol_id
	 * @return
	 * @throws ServiceException
	 */
	//UserAuth_Rol findByUserIdAndRolId(Long userauth_id, Long rol_id) throws ServiceException;

}
