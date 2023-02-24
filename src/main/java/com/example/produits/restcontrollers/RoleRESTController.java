package com.example.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entitys.Role;
import com.example.produits.repository.RoleRepository;




	@RestController
	@CrossOrigin(origins = "*")
	public class RoleRESTController {
		@Autowired
		RoleRepository roleRep;
		

		@RequestMapping(path = "roles", method = RequestMethod.GET)
		public List<Role> getAllRoles() {
			return roleRep.findAll();
		}
		
		
		
		
		
	}