package com.raftel.cartservice.model;

public class Item {
	String prodName;
	double price;
	int quantity;
	
	public Item() {}
	
	public Item(String prodName, double price, int quantity) {
		super();
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [prodName=" + prodName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
