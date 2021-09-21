package com.raftel.adminservice.model;

public class Product {
	int id;
	String name;
	String category;
	public Product() {}
	public Product(int id, String name, String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
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
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
	
}
