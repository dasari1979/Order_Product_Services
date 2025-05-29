package com.task.product.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.product.service.entity.Product;
import com.task.product.service.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ProductController {

@Autowired	
ProductService productService;

@PostMapping("/")
public ResponseEntity<Product> saveProducts(@RequestBody Product product){
	
	log.info("Saving products...."+product);
	Product saveProducts = productService.saveProducts(product);
	
	return ResponseEntity.ok().body(saveProducts);
	
}

@GetMapping("/")
public List<Product> getAllProducts(){	
	List<Product> allProducts = productService.getAllProducts();
	log.info("Feteching product information...");
	return allProducts;
	
}

@GetMapping("/{id}")
public Product getProductById(@PathVariable String id){
	
	Product product = productService.getProductById(Long.parseLong(id));
	log.info("Fetch product information by id... "+id);
	return product;
	
}
}
