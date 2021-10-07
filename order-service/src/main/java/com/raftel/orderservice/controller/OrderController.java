package com.raftel.orderservice.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.raftel.orderservice.Repository.IdRepository;
import com.raftel.orderservice.Repository.OrderRepository;
import com.raftel.orderservice.model.IdGenerator;
import com.raftel.orderservice.model.Item;
import com.raftel.orderservice.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	IdRepository idRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("")
	public void addOrder(@RequestBody Order order) {
		IdGenerator idGen= idRepo.findById("orderId").get();
		order.setId(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		order.setDate(LocalDate.now());
		orderRepo.save(order);
		System.out.println(order.getCustomerId());
	}
	
	@GetMapping("")
	public List<Order> getAllOrders(){
		List<Order> orders= new ArrayList<>();
		orderRepo.findAll().forEach(orders::add);
		return orders;
	}
	
	@GetMapping("/all/{userId}")
	public List<Order> getAllOrders(@PathVariable("userId") int userId) {
		List<Order> orders = new ArrayList<>();
		orderRepo.findAll().stream().forEach(order ->{
			if(order.getCustomerId()==userId)
				orders.add(order);
		});
		return orders;
	}
	
	@GetMapping("/all/items/{userId}")
	public Collection<Collection<Item>> getAllItems(@PathVariable("userId") int userId){
		Collection<Collection<Item>> list= new ArrayList<>();
		getAllOrders(userId).forEach(order->list.add(order.getItems().values()));
		return list;
	}
	
	@GetMapping("/{userId}")
	public Order getOrder(@PathVariable("userId") int userId) {
		
		List<Order> orders= getAllOrders(userId);
		return orders.get(orders.size()-1);
	}
	
	@GetMapping("/items/{userId}")
	public Collection<Item> getItems(@PathVariable("userId") int userId){
		return getOrder(userId).getItems().values();
	}
	
}
