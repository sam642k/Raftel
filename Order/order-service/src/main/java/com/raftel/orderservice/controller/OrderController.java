package com.raftel.orderservice.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raftel.orderservice.Repository.IdRepository;
import com.raftel.orderservice.Repository.OrderRepository;
import com.raftel.orderservice.model.IdGenerator;
import com.raftel.orderservice.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	IdRepository idRepo;
	
	@PostMapping("")
	public void addOrder(@RequestBody Order order) {
		IdGenerator idGen= idRepo.findById("orderId").get();
		order.setId(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		order.setDate(LocalDate.now());
		orderRepo.save(order);
	}
	
	@GetMapping("")
	public List<Order> getAllOrders(){
		List<Order> orders= new ArrayList<>();
		orderRepo.findAll().forEach(orders::add);
		return orders;
	}
	
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id") int id) {
		return orderRepo.findById(id).get();
	}
	
}
