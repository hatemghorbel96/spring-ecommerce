package com.example.produits;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.produits.entitys.Categorie;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.Role;
import com.example.produits.entitys.User;
import com.example.produits.service.UserService;


@SpringBootApplication
public class CategoryProduitApplication  {
	
	
	@Autowired
	UserService userService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CategoryProduitApplication.class, args);
		
		
	}
	/*
	@PostConstruct
	void init_users() {
		
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"USER"));
	
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"hatem","123",true,null));
	userService.saveUser(new User(null,"kakarotto","123",true,null));
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("admin", "USER");
	userService.addRoleToUser("hatem", "USER");
	userService.addRoleToUser("kakarotto", "USER");
	}
	*/
	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}
	
	
	

}
