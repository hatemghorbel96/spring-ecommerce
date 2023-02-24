package com.example.produits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.produits.entitys.Comment;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.User;
import com.example.produits.repository.CommentRepository;
import com.example.produits.repository.ProduitRepository;
import com.example.produits.repository.UserRepository;
@Transactional
@Service
public class CommentServiceImp implements CommentService{

	@Autowired  //injection
	ProduitRepository produitrepository;
	
	@Autowired  //injection
	UserRepository userRep;
	
	@Autowired  //injection
	CommentRepository comRep;
	
	
	@Override
	public void addcomment(Long id, String username) {
		User u = userRep.findByUsername(username);
		Produit p= produitrepository.findById(id).get();
		Comment c = new Comment();
		c.setUser(u);
		c.setProduit(p);
		comRep.save(c);
		
		
	}


	@Override
	public Comment saveComment(Comment c) {
		// TODO Auto-generated method stub
		return comRep.save(c);
	}


	@Override
	public Comment updateComment(Comment c) {
		// TODO Auto-generated method stub
		return comRep.save(c);
	}

}
