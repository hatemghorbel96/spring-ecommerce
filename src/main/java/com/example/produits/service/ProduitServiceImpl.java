package com.example.produits.service;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.produits.dto.ListProduit;
import com.example.produits.entitys.Categorie;
import com.example.produits.entitys.Produit;
import com.example.produits.entitys.User;
import com.example.produits.repository.ProduitRepository;
import com.example.produits.repository.UserRepository;
@Transactional
@Service
public class ProduitServiceImpl implements ProduitService {

		@Autowired  //injection
		ProduitRepository produitrepository;
		
		@Autowired  //injection
		UserRepository userRep;
	
	@Override
	public Produit saveProduit(Produit p) {
		return produitrepository.save(p);
		 
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitrepository.save(p);
		
	}

	@Override
	public void deleteProduit(Produit p) {
		
		 produitrepository.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		 produitrepository.deleteById(id);
		
		
	}

	@Override
	public Produit getProduit(Long id) {
		
		return  produitrepository.findById(id).get();
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return  produitrepository.findAll();
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		// TODO Auto-generated method stub
		return produitrepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		// TODO Auto-generated method stub
		return produitrepository.findByNomProduitContains(nom);
	}

	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return produitrepository.findByNomPrix(nom,prix);
	}
	
	@Override
	public List<Produit> findMaxPrix(Double maxprod, Double minprod) {
		// TODO Auto-generated method stub
		return produitrepository.findMaxPrix(maxprod,minprod);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return produitrepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return produitrepository.findByCategorieIdCategory(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		// TODO Auto-generated method stub
		return produitrepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> trierProduitsNomsPrix() {
		// TODO Auto-generated method stub
		return produitrepository.trierProduitsNomsPrix();
	}

	@Override
	public Produit addFavorit(String username, Long idProduit) {
		// TODO Auto-generated method stub
		User u = userRep.findByUsername(username);
		Produit p =produitrepository.findById(idProduit).get();		
		p.getFavorits().add(u);
		return p;
	}
	
	@Override
	public Produit removeFavorit(String username, String nomProduit) {
		// TODO Auto-generated method stub
		User u = userRep.findByUsername(username);
		Produit p =produitrepository.findByNomProduit(nomProduit).get(0);		
		p.getFavorits().remove(u);
		return p;
		
	}



	

	

	
	
}
