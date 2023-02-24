package com.example.produits.service;

import java.util.List;

import com.example.produits.entitys.Categorie;
import com.example.produits.entitys.Produit;

public interface CategorieService {

	Categorie saveCategorie(Categorie c);
	Categorie updateCategorie(Categorie c);
	void deleteCategorie(Categorie c);
	void deleteCategorieById(Long id);
	Categorie getCategorie(Long id);
	List<Categorie> getAllCategories();
}
