package com.lanches.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanches.api.model.Product;

public interface ProductRespository extends JpaRepository<Product, Long>{

}
