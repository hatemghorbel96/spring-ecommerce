package com.example.produits.entitys;

import org.springframework.data.rest.core.config.Projection;


// pour afficher ken el les nom du produits
@Projection(name="nomProduit" ,types = {Produit.class})
public interface ProduitProjection {

		public String getNomProduit();
}
