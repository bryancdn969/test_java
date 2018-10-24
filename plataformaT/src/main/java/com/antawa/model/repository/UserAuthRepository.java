package com.antawa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.antawa.model.UserAuth;

/**
 * 
 * @author BO <@gmail.com>.
 * 
 *         this the user Repository interface
 */
@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long>{

//	@Query("select enabled "
//			+ "from userAuth_rol, rol, user_auth "
//			+ "where id_ua=:userauth_id and id_rol =:rol_id")
//	UserAuth_Rol findByUserIdAndRolId(@Param("userauth_id") Long userauth_id, @Param("rol_id") Long rol_id);
	
	//UserAuth findOneByUsername(String username);
	UserAuth findByUserNameAndPassword(String userName, String password);

}
