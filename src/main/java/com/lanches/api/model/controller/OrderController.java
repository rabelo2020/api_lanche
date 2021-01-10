package com.lanches.api.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanches.api.model.Order;
import com.lanches.api.model.repository.OrderRespository;

@RestController
@RequestMapping("/ordres")
public class OrderController {
	
	@Autowired
	private OrderRespository orderRespository;
	
	@GetMapping
	public List<?> buscarTodos(){
		return orderRespository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> buscarId(@PathVariable Long id) {
		Order aa = orderRespository.findById(id).orElse(null);
		return aa != null ? ResponseEntity.ok().body(aa) : 
			ResponseEntity.badRequest().build();
	}
	
	

}
