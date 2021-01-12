package com.lanches.api.model.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanches.api.model.Product;
import com.lanches.api.model.Exception.EntidadeNaoEncontradaException;
import com.lanches.api.model.dto.ProductDto;
import com.lanches.api.model.repository.ProductRespository;

@Service
public class ProductService {

	@Autowired
	private ProductRespository productRespository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ProductDto> buscarTodos() {

		List<Product> product = productRespository.findAll();

		return product.stream().map(a -> new ProductDto(a)).collect(Collectors.toList());

	}

	public List<ProductDto> buscarPorName() {
		List<Product> products = productRespository.findAllByOrderByNameAsc();

		return products.stream().map(x -> productDtoModelMapper(x)).collect(Collectors.toList());

	}

	private ProductDto productDtoModelMapper(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}

	public ProductDto buscarOuFalhar(Long id) {

		Product product = productRespository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
		return new ProductDto(product);
	}

}
