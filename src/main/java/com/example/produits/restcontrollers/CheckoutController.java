package com.example.produits.restcontrollers;
import org.springframework.web.bind.annotation.*;

import com.example.produits.dto.Purchase;
import com.example.produits.dto.PurchaseResponse;
import com.example.produits.service.CheckoutService;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}