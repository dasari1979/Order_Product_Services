package com.task.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.product.service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
