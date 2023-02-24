package com.example.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entitys.Comment;
import com.example.produits.entitys.Order;
import com.example.produits.entitys.Produit;
import com.example.produits.repository.OrderRepository;
import com.example.produits.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin (origins = "*")
public class OrderRESTController {

		@Autowired
		OrderService orderservice;
		
		@Autowired
		OrderRepository orderRep;
		
		@RequestMapping(path="all",method=RequestMethod.GET)
		public List<Order> getAllOrders()
		{
			return orderservice.getAllOrders();
		}
		
		@RequestMapping(value="/{id}",method = RequestMethod.GET)
		public Order getOrderById(@PathVariable("id") Long id) {
		return orderservice.getOrder(id);
		}
		
		// fel postman id yetekteb fel body
		@RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
		public ResponseEntity<Order> updateOrder(@RequestBody Order o,@PathVariable("id") Long id) {
			
			Order getorder= orderRep.findById(id).get();
			getorder.setOrderItems(getorder.getOrderItems());
			getorder.setUser(getorder.getUser());
			getorder.setShippingAddress(getorder.getShippingAddress());
			getorder.setBillingAddress(getorder.getBillingAddress());
			getorder.setStatus(o.getStatus());
			getorder.setOrderTrackingNumber(getorder.getOrderTrackingNumber());
			getorder.setTotalQuantity(getorder.getTotalQuantity());
			getorder.setTotalPrice(getorder.getTotalPrice());
			
			Order updatedOrder =orderRep.save(getorder);	
		
		return ResponseEntity.ok().body(updatedOrder);
		}
		
		@RequestMapping(value="user/{username}",method = RequestMethod.GET)
		public List<Order> getOrderByUser(@PathVariable("username") String username) {
		return orderservice.getOrdersByUser(username);
		}
		
		
		
}
