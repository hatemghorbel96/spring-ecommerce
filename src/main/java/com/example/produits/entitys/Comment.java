package com.example.produits.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComment;
	private int rating;
	private String content;
	@CreationTimestamp
	private Date dateCreation;
	
	
    @UpdateTimestamp
    private Date UpdatedAt;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JsonBackReference("produit")
	private Produit produit;

	
	
	
	
}
