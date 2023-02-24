package com.example.produits.service;

import java.util.List;

import com.example.produits.entitys.Order;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.User;


public interface OrderService {

	Order getOrder(Long id);
	List<Order> getAllOrders();
	Order updateOrder(Order o);
	List<Order> getOrdersByUser(String username);
}
