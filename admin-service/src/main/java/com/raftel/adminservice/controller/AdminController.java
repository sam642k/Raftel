package com.raftel.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.raftel.adminservice.model.Product;

@RefreshScope
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@PutMapping("/get-products")
	public Product getProducts() {
		return restTemplate.getForObject("http://vendor-service/vendor/get-products", Product.class);
	}
}