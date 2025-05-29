package com.task.product.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.product.service.entity.Product;
import com.task.product.service.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
		
	}
	public Product getProductById(Long id){

		return productRepository.findById(id).get();		
	}
	
	public Product saveProducts(Product product){
		
		Product savedProducts = productRepository.save(product);
		
		return savedProducts;
		
	}
}
