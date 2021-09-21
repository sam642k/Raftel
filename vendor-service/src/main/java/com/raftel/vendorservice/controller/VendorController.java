package com.raftel.vendorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.raftel.vendorservice.model.Product;

@RefreshScope
@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${msg: no}")
	String greet;
	
	
	@GetMapping("/yo/{lol}")
	public String lol(@PathVariable("lol") String lol) {
		return "<h1>"+greet+" "+lol+"</h1>";
	}
	
	@PostMapping("/add-product")
	public void addProduct() {
	}
	
	@RequestMapping("/get-products")
	public Product getProducts() {
		return new Product(1, "samsung", "mobile");
	}
	
}
