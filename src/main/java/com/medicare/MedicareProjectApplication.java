package com.medicare;

import com.medicare.entity.Role;
import com.medicare.entity.User;
import com.medicare.entity.UserRole;
import com.medicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MedicareProjectApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(MedicareProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("starting code");
//		User user=new User();
//
//		user.setFirstName("Sharjil");
//		user.setLastName("Dhanani");
//		user.setUsername("jil");
//		user.setPasword("abc");
//		user.setEmail("avc@gmail.com");
//		user.setProfile("default.png");
//
//		Role role=new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//		User user1=this.userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());
//
//



	}
}
