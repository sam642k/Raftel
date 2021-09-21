package com.raftel.catalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raftel.catalogservice.model.IdGenerator;
import com.raftel.catalogservice.model.Product;
import com.raftel.catalogservice.repo.IdRepository;
import com.raftel.catalogservice.repo.ProductRepository;

@RestController
@RequestMapping("/catalog-service")
public class CatalogController {
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	IdRepository idRepo;
	
	@GetMapping("/all")
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
	
}
