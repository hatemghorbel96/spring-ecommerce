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
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.User;
import com.example.produits.repository.CommentRepository;
import com.example.produits.repository.ProduitRepository;
import com.example.produits.repository.UserRepository;
import com.example.produits.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentRESTController {
	
	@Autowired
	CommentService commentservice;
	
	@Autowired  //injection
	ProduitRepository produitrepository;
	
	@Autowired  //injection
	UserRepository userRep;
	
	@Autowired  //injection
	CommentRepository comRep;
	
	@RequestMapping(value = "add/{id}/{username}",method = RequestMethod.POST)
	public void addcomment(@PathVariable("id") Long id,@PathVariable("username") String username,@RequestBody Comment c) {
	
	 User u = userRep.findByUsername(username);
	Produit p= produitrepository.findById(id).get();
	 c.setUser(u);
		c.setProduit(p);
		comRep.save(c);	 
	}
	
	@RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Comment> updatecomment(@PathVariable("id") Long id,@RequestBody Comment c) {
	
	 
		Comment getcomm= comRep.findById(id).get();
		getcomm.setProduit(getcomm.getProduit());
		getcomm.setUser(getcomm.getUser());
		getcomm.setContent(c.getContent());
		getcomm.setRating(c.getRating());
		getcomm.setDateCreation(null);
		Comment updatedcom =comRep.save(getcomm);	
		
		return ResponseEntity.ok().body(updatedcom);
	}
	
	@RequestMapping(value="/{IdProduit}",method = RequestMethod.GET)
	public List<Comment> getCommentByProduitId(@PathVariable("IdProduit") Long IdProduit) {
	return comRep.findByProduitIdProduit(IdProduit);
	}
	
	@RequestMapping(value="/get/{id}",method = RequestMethod.GET)
	public Comment getCommentById(@PathVariable("id") Long id) {
	return comRep.findById(id).get();
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public void deletebyid(@PathVariable("id") Long id) {
			comRep.deleteById(id);
	}
}
