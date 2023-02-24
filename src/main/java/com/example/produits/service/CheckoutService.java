package com.example.produits.service;

import java.security.Principal;

import com.example.produits.dto.Purchase;
import com.example.produits.dto.PurchaseResponse;

public interface CheckoutService {
	
	 PurchaseResponse placeOrder(Purchase purchase);

	


}
