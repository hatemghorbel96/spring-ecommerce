package com.example.produits.service;

import java.util.List;

import com.example.produits.dto.ListProduit;
import com.example.produits.entitys.Categorie;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.User;

public interface ProduitService {

	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	Produit getProduit(Long id);
	
	
	  Produit addFavorit(String username, Long idProduit); Produit
	  removeFavorit(String username, String nomProduit);
	 
	List<Produit> getAllProduits();
	

	
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomPrix (String nom, Double prix);
	List<Produit> findByCategorie (Categorie categorie);
	List<Produit> findByCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> trierProduitsNomsPrix();
	List<Produit> findMaxPrix (Double maxprod, Double minprod);
	
	
	
}
