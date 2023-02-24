package com.example.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produits.entitys.Order;
import com.example.produits.entitys.User;
import com.example.produits.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired  //injection
	OrderRepository orderrepository;
	
	@Override
	public Order getOrder(Long id) {
		// TODO Auto-generated method stub
		return  orderrepository.findById(id).get();
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderrepository.findAll();
	}

	@Override
	public Order updateOrder(Order o) {
		// TODO Auto-generated method stub
		return orderrepository.save(o);
	}

	@Override
	public List<Order> getOrdersByUser(String username) {
		// TODO Auto-generated method stub
		return orderrepository.findAllByUserUsername(username);
	}

}
