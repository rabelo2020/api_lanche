package com.lanches.api.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanches.api.model.Order;
import com.lanches.api.model.Product;
import com.lanches.api.model.repository.OrderRespository;
import com.lanches.api.model.repository.ProductRespository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRespository produtRespository;
	
	@GetMapping
	public List<?> buscarTodos(){
		return produtRespository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> buscarId(@PathVariable Long id) {
		Product aa = produtRespository.findById(id).orElse(null);
		return aa != null ? ResponseEntity.ok().body(aa) : 
			ResponseEntity.badRequest().build();
	}
	
	

}
