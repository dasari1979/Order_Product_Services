package com.task.order.service.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.task.order.service.entity.Order;
import com.task.order.service.entity.ProductDTO;
import com.task.order.service.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public ProductDTO createOrder(Order order) {
		order.setOrderDate(LocalDateTime.now());
		ProductDTO products = null;
		List<ProductDTO> fetchedProducts = new ArrayList<>();
		for(Long productId : order.getProductIds()) {
		log.info("Products: "+productId);	
		String id = String.valueOf(productId);
		String productUrl = "http://localhost:8000/products/"+id;
		products = restTemplate.getForObject(productUrl, ProductDTO.class,id);
		fetchedProducts.add(products);
		log.info("Products: "+products);		
		}
		orderRepository.save(order);
		return products;
	}
}