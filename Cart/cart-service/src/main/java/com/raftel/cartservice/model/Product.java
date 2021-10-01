package com.raftel.cartservice.model;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class Product {
	
	@Id
	int id;
	private String name;
	private String category;
	private double price;
	private String description;
	private Map<String, String> specifications;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	} 
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", description="
				+ description + ", specifications=" + specifications + "]";
	}
	
}
