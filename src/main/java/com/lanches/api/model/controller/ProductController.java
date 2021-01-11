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
import com.lanches.api.model.dto.ProductDto;
import com.lanches.api.model.repository.OrderRespository;
import com.lanches.api.model.repository.ProductRespository;
import com.lanches.api.model.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductDto> buscarTodos(){
		return productService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> buscarId(@PathVariable Long id) {
		ProductDto aa = productService.buscarOuFalhar(id);
		return ResponseEntity.ok(aa);
	}
	
	

}
