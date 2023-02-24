package com.example.produits.service;

import java.util.List;


import com.example.produits.entitys.Role;
import com.example.produits.entitys.User;




public interface UserService {
	User saveUser(User user);
	User updateUser(User u);
	User getUser(Long id);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers();
	User removeRoleFromUser(String username, String role);
	User updatepasswordbyId(User u);
	

}
