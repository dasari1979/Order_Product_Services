package com.task.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.order.service.entity.Order;
import com.task.order.service.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		log.info("Creating order..."+order);
		orderService.createOrder(order);
		return ResponseEntity.ok().build();		
	}

}
