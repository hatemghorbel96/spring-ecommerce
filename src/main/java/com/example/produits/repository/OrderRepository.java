package com.example.produits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.produits.entitys.Order;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.User;

@RepositoryRestResource(path = "rest")
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> findAllByUserUsername(String username);
	
	
	 @Query("select u,SUM(o.totalPrice) as tt from User u inner join Order o on u.id=o.user.id group by (o.user) ORDER BY tt DESC ")
	 List<User> gg (); 
}
