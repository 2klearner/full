package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Product;


public interface ProductRepo extends JpaRepository<Product, Integer>{

	
	
}
