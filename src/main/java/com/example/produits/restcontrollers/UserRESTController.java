package com.example.produits.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entitys.Order;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.User;
import com.example.produits.repository.UserRepository;
import com.example.produits.service.UserService;




@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserRESTController {
	@Autowired
	UserRepository userRep;
	@Autowired
	UserService userSer;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
	return userSer.saveUser(user);
	}

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRep.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
	return userSer.updateUser(user);
	}
	
	@RequestMapping(path = "addrole/{username}/{role}",method = RequestMethod.POST)
	public User addroletouser(@PathVariable("username") String username,@PathVariable("role") String role) {
	return userSer.addRoleToUser(username,role);
	}
	
	@RequestMapping(path = "removerole/{username}/{role}",method = RequestMethod.POST)
	public User removeroletouser(@PathVariable("username") String username,@PathVariable("role") String role) {
	return userSer.removeRoleFromUser(username,role);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id) {
	return userSer.getUser(id);
	}
	
	@RequestMapping(value="getUser/{username}",method = RequestMethod.GET)
	public User getUserbyusername(@PathVariable("username") String username) {
	return userSer.findUserByUsername(username);
	}
	
	@RequestMapping(value = "info/{username}",method = RequestMethod.PUT)
	public ResponseEntity<User> updateinfo(@RequestBody User u,@PathVariable("username") String username) {
		
		User getuser= userSer.findUserByUsername(username);
		getuser.setUsername(getuser.getUsername());
		
		getuser.setEnabled(getuser.getEnabled());
	
		
		
		
		
		getuser.setFirstname(u.getFirstname());	
		getuser.setLastname(u.getLastname());	
		getuser.setPhone(u.getPhone());	
		getuser.setEmail(getuser.getEmail());	
		
		
		User updatedOrder =userRep.save(getuser);	
	
	return ResponseEntity.ok().body(updatedOrder);
	}
	
	@RequestMapping(value = "password/{username}",method = RequestMethod.PUT)
	public ResponseEntity<User> updatePassword(@RequestBody User u,@PathVariable("username") String username) {
		
		User getuser= userSer.findUserByUsername(username);
		getuser.setUsername(getuser.getUsername());
		getuser.setFirstname(getuser.getFirstname());
		getuser.setLastname(getuser.getLastname());
		getuser.setPhone(getuser.getPhone());
		getuser.setEnabled(getuser.getEnabled());
		getuser.setRoles(getuser.getRoles());
		getuser.setComments(getuser.getComments());
		
		
		getuser.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		
		
		
		User updatedOrder =userRep.save(getuser);	
	
	return ResponseEntity.ok().body(updatedOrder);
	}
	
	
	
	
	
}