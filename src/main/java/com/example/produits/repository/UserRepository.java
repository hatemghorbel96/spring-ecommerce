package com.example.produits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produits.entitys.User;



public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
