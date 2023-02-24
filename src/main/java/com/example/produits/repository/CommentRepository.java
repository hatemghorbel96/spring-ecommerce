package com.example.produits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produits.entitys.Comment;
import com.example.produits.entitys.Produit;


public interface CommentRepository extends JpaRepository<Comment, Long>{

	List<Comment> findByProduitIdProduit(Long id);

}
