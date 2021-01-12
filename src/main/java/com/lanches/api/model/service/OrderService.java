package com.lanches.api.model.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanches.api.model.Order;
import com.lanches.api.model.Product;
import com.lanches.api.model.Exception.EntidadeNaoEncontradaException;
import com.lanches.api.model.dto.OrderDto;
import com.lanches.api.model.dto.ProductDto;
import com.lanches.api.model.repository.OrderRespository;
import com.lanches.api.model.repository.ProductRespository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRespository orderRespository;
	
	@Autowired
	private ProductRespository productRespository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional(readOnly = true) //Somente Leitura no Banco de Dados
	public List<OrderDto> buscarTodos() {
		List<Order> orders = orderRespository.findOrdersWithProducts();
		return orders.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
		// return orderRespository.findAll().stream().map(a ->
		// orderDto(a)).collect(Collectors.toList());
	}
	
	@Transactional //fazendo uma alteração no Banco de Dados
	public OrderDto salvarPedido(OrderDto dto) {
		
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now()
				, dto.getStatus().PENDING);
		
		for (ProductDto p : dto.getProductDtos()) {

			Product product = productRespository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
	order = orderRespository.save(order);
	return new OrderDto(order);

	}

	public OrderDto buscarOuFalhar(Long id) {

		Order order = orderRespository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
		return orderDto(order);

	}
	
	private OrderDto orderDto(Order order) {
		return modelMapper.map(order, OrderDto.class);

	}



}
