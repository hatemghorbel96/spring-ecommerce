package com.example.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.produits.entitys.Categorie;
import com.example.produits.entitys.Produit;
import com.example.produits.repository.CategorieRepository;
import com.example.produits.service.CategorieService;
import com.example.produits.service.ProduitService;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTController {
	
	@Autowired
	CategorieService categorieservice;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Categorie> getAllCategories()
	{
		
	return categorieservice.getAllCategories();
	
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id) {
		
	return categorieservice.getCategorie(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Categorie createCategorie(@RequestBody Categorie categorie) {
	return categorieservice.saveCategorie(categorie);
	}
	
	// fel postman id yetekteb fel body
	@RequestMapping(method = RequestMethod.PUT)
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
	return categorieservice.updateCategorie(categorie);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCategorie(@PathVariable("id") Long id)
	{
		categorieservice.deleteCategorieById(id);
	}
	
}
