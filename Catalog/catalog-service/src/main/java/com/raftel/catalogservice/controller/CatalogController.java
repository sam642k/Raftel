package com.raftel.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raftel.catalogservice.model.IdGenerator;
import com.raftel.catalogservice.model.Product;
import com.raftel.catalogservice.repository.IdRepository;
import com.raftel.catalogservice.repository.ProductRepository;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	IdRepository idRepo;
	
	@GetMapping("")
	public List<Product> getAll(){
		List<Product> list= new ArrayList<>();
		prodRepo.findAll().stream().forEach(list::add);
		return list;
	}
	
	@GetMapping("/idSeq")
	public int getNextId() {
		IdGenerator idGen= idRepo.findById("prodId").get();
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		return idGen.getSeq()-1;
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		return prodRepo.findById(id).get();
	}
	
}
