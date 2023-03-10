package com.example.produits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.produits.dto.ListProduit;
import com.example.produits.entitys.Categorie;
import com.example.produits.entitys.Produit;



public interface ProduitRepository extends JpaRepository<Produit, Long> {

	
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	
	//simple
	/* @Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix (String nom, Double prix); */
	
	
	// n7adedou parameter kima addparameter fi sym
	 @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix); 
	
	// n7adedou parameter kima addparameter fi sym
		 @Query("select p from Produit p where p.prixProduit <= :maxprod and p.prixProduit >= :minprix")
		List<Produit> findMaxPrix (@Param("maxprod") Double maxprod,@Param("minprix") Double minprix); 
	
	// search by entity
	@Query("select p from Produit p where p.categorie = ?1")
	List<Produit> findByCategorie (Categorie categorie);
	

	
	// Categorie houwa type mte3 category fi produit
	List<Produit> findByCategorieIdCategory (Long id);
	
	List<Produit> findByOrderByNomProduitAsc();
	
	
	// wa9t yebda multiple na3mlou el query
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix ();
	
	
	
	
}
