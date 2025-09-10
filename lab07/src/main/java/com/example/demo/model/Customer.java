package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String name;
	
	protected Customer() {
		
	}
	
	public Customer(String name) {
		this.name = name;
	}
	
	public Long getId() { return id; }
	@JsonProperty("customerName")
	public String getName() { return name; }

	@JsonProperty("customerName")
	public void setName(String string) { this.name = string; }
	
	public void setId(Long id) { this.id = id; }

	@Override 
	public String toString() { return id + " : " + name; } 
	
	
}
