package com.example.produits.dto;


import lombok.Data;

import java.util.Set;

import com.example.produits.entitys.Address;
import com.example.produits.entitys.Order;
import com.example.produits.entitys.OrderItem;
import com.example.produits.entitys.User;



@Data
public class Purchase {

	private User user;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
