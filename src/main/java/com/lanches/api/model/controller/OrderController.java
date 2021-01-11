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
import com.lanches.api.model.dto.OrderDto;
import com.lanches.api.model.repository.OrderRespository;
import com.lanches.api.model.service.OrderService;

@RestController
@RequestMapping("/ordres")
public class OrderController {
	
	@Autowired
	private OrderRespository orderRespository;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List<OrderDto> buscarTodos(){
		return orderService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> buscarId(@PathVariable Long id) {
		OrderDto aa = orderService.buscarOuFalhar(id);
		return ResponseEntity.ok(aa);
	}
	
	
	
	
	

}
