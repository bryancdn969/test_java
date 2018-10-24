package com.antawa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.antawa.model.Rol;
import com.antawa.model.UserAuth;
import com.antawa.model.repository.RolRepository;
import com.antawa.model.repository.UserAuthRepository;
/**
 * 
 * @author kamal berriga
 *
 */
@SpringBootApplication
public class SpringBootAntawaApplication {
	
	@Autowired
	private RolRepository rolRepository;

	@Autowired
private UserAuthRepository userAuthRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAntawaApplication.class, args);
	}
	
//	@Override
//	public void run(String... args) throws Exception {
//		// Cleanup the tables
//		rolRepository.deleteAllInBatch();
//		userAuthRepository.deleteAllInBatch();
//
//		// =======================================
//
//		// Create a Post
//		UserAuth post = new UserAuth();
//
//		// Create two tags
//		Rol tag1 = new Rol();
//		Rol tag2 = new Rol();
//
//
//		// Add tag references in the post
//		post.getRoles().add(tag1);
//		post.getRoles().add(tag2);
//
//		// Add post reference in the tags
//		tag1.getUserAuth().add(post);
//		tag2.getUserAuth().add(post);
//
//		rolRepository.save(post);
//
//		// =======================================

//}
}
