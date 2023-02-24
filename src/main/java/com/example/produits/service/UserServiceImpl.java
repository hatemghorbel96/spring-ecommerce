package com.example.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.produits.entitys.Produit;
import com.example.produits.entitys.Role;
import com.example.produits.entitys.User;
import com.example.produits.repository.ProduitRepository;
import com.example.produits.repository.RoleRepository;
import com.example.produits.repository.UserRepository;




@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}
	
	@Override
	public User updatepasswordbyId(User u) {
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		return userRep.save(u);
	}
	
	

	@Override
	public User findUserByUsername(String username) {
		return userRep.findByUsername(username);
	}

	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public User addRoleToUser(String username, String role) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(role);
		usr.getRoles().add(r);
		return usr;
	}
	
	@Override
	public User removeRoleFromUser(String username, String role) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(role);
		usr.getRoles().remove(r);
		return usr;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRep.findAll() ;
	}



	



	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return  userRep.findById(id).get();
	}



	
	

}
