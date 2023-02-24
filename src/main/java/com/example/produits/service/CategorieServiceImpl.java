package com.example.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.produits.entitys.Categorie;
import com.example.produits.repository.CategorieRepository;
import com.example.produits.repository.ProduitRepository;
@Service
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired  //injection
	CategorieRepository categorierepository;
	
	@Override
	public Categorie saveCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorierepository.save(c);
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorierepository.save(c);
	}

	@Override
	public void deleteCategorie(Categorie c) {
		 categorierepository.delete(c);
		
	}

	@Override
	public void deleteCategorieById(Long id) {
		categorierepository.deleteById(id);
		
	}

	@Override
	public Categorie getCategorie(Long id) {
		// TODO Auto-generated method stub
		return  categorierepository.findById(id).get();
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return  categorierepository.findAll();
	}

}
