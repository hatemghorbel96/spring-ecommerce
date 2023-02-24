package com.example.produits.entitys;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@Column(unique = true)
	private String username;
	private String password;
	private Boolean enabled;
	private String firstname;
	private String lastname;
	private String phone;
	private String email;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private Set<Comment> comments;
	
	
	
	 
	
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	 @JsonIgnoreProperties("user")  // mel chirtine tdhahar
	    private Set<Order> orders = new HashSet<>();

	    public void add(Order order) {

	        if (order != null) {

	            if (orders == null) {
	                orders = new HashSet<>();
	            }

	            orders.add(order);
	            order.setUser(this);
	        }
	    }
}