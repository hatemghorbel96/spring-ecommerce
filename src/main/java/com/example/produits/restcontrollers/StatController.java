package com.example.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entitys.Order;
import com.example.produits.entitys.User;
import com.example.produits.repository.OrderRepository;
import com.example.produits.service.OrderService;

@RestController
@RequestMapping("/stat")
@CrossOrigin (origins = "*")
public class StatController {
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	OrderRepository orderRep;
	
	@RequestMapping(value="get",method = RequestMethod.GET)
	public List<User> getstat() {
	return orderRep.gg();
	}

}
