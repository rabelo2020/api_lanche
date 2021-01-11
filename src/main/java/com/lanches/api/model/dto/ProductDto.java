package com.lanches.api.model.dto;

import com.lanches.api.model.Product;

public class ProductDto {
	
	//private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto( String name, Double price, String description, String imageUri) {
		
		//this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imageUri;
	}
	
	public ProductDto (Product product) {
		//id = product.getId();
		name = product.getName();
		price = product.getPrice();
		description = product.getDescription();
		imageUri = product.getImageUri();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
	
	
	
	
	

}
