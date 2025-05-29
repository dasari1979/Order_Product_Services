package com.task.product.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.product.service.entity.LoginRequest;

@Repository
public interface LoginRepository extends JpaRepository<LoginRequest, String> {
	List<LoginRequest> findByEmail(String email);
}
