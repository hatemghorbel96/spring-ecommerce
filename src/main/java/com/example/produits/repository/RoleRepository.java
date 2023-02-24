package com.example.produits.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produits.entitys.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}