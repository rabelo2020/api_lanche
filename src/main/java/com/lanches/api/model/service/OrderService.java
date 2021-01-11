package com.lanches.api.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanches.api.model.Order;
import com.lanches.api.model.Exception.EntidadeNaoEncontradaException;
import com.lanches.api.model.dto.OrderDto;
import com.lanches.api.model.repository.OrderRespository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRespository orderRespository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<OrderDto> buscarTodos() {
		
		return orderRespository.findAll().stream().map(a -> orderDto(a)).collect(Collectors.toList());
	}

	public OrderDto buscarOuFalhar(Long id) {

		Order order = orderRespository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
		
		return orderDto(order);
		
	}
	
private OrderDto orderDto(Order order) {
	return modelMapper.map(order, OrderDto.class);
		
	}

}
