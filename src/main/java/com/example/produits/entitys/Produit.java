package com.example.produits.entitys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	@Column(unique = true)
	private String nomProduit;
	private Double prixProduit;
	private Boolean trend;
	private Double promo;
	@CreationTimestamp
	private Date dateCreation;
	private String imgurl;
	private Boolean bestoffer;
	private Boolean pub1;
	private Boolean pub2;
	@ManyToOne	
	private Categorie categorie;
	
	
	@OneToMany(mappedBy="produit")
	@JsonManagedReference("produit")
	private List<Comment> comments= new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name= "product_images",
			joinColumns= {
					@JoinColumn(name="id_product")
					
			},
			
			inverseJoinColumns = {
					@JoinColumn(name="image_id")
			}
		)
	private Set<ImageModel> productImages;
	
	
	
	
	  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  
	  @JoinTable(name = "produit_user", joinColumns = @JoinColumn(name =
	  "idProduit"), inverseJoinColumns = @JoinColumn(name = "user_id")) 
	  private List<User> favorits= new ArrayList<>();
	 
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "produit_user", joinColumns = {
	 * 
	 * @JoinColumn(name = "idProduit", referencedColumnName = "idProduit") },
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "user_id", referencedColumnName = "user_id") } )
	 * 
	 * @JsonManagedReference private List<User> favorits= new ArrayList<>();
	 */
	 

	
	/*
	 * @PrePersist void createdAt() { this.createdAt = new Date(); }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
