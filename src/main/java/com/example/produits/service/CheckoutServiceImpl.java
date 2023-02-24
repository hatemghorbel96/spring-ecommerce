package com.example.produits.service;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.produits.dto.Purchase;
import com.example.produits.dto.PurchaseResponse;
import com.example.produits.entitys.Order;
import com.example.produits.entitys.OrderItem;
import com.example.produits.entitys.User;
import com.example.produits.repository.UserRepository;


import javax.transaction.Transactional;

import java.security.Principal;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private UserRepository userRepository;

    public CheckoutServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        order.setStatus(1);
        // populate customer with order
       // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
      
		/*
		 * Authentication authentication = (Authentication) principal; User user =
		 * (User) authentication.getPrincipal();
		 * 
		 * 
		 * user.add(order);
		 */
        
     // populate customer with order
        User user = purchase.getUser();

        // check if this is an existing customer
        String username = user.getUsername();

        User customerFromDB = userRepository.findByUsername(username);

        if (customerFromDB != null) {
            // we found them ... let's assign them accordingly
            user = customerFromDB;
        }

        user.add(order);
     

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }

	
}