package com.lanches.api.model.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lanches.api.model.Order;
import com.lanches.api.model.Product;
import com.lanches.api.model.dto.OrderDto;
import com.lanches.api.model.repository.OrderRespository;
import com.lanches.api.model.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ordres")
public class OrderController {
	
		
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<OrderDto>> buscarTodos(){
	List<OrderDto> dtos = orderService.buscarTodos();
	return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDto> buscarId(@PathVariable Long id) {
		OrderDto aa = orderService.buscarOuFalhar(id);
		return ResponseEntity.ok().body(aa);
	}
	
	@PostMapping
	public ResponseEntity<OrderDto> cadastradarPedido(@RequestBody OrderDto orderDto) {
		orderDto = orderService.salvarPedido(orderDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(orderDto.getId())
				.toUri();

		return ResponseEntity.created(uri).body(orderDto);
	}

	/*
	 * @GetMapping public ResponseEntity<OrderDto> buscarOdenadaNome(){
	 * orderService.buscarPorNome(); }
	 */
	
	
	
	
	

}
