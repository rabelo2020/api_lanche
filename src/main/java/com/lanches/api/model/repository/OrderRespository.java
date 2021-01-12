package com.lanches.api.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lanches.api.model.Order;

@Repository
public interface OrderRespository extends JpaRepository<Order, Long>{
	
@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products"
		+ " WHERE obj.status = 0 ORDER BY obj.moment DESC")
	List<Order> findOrdersWithProducts();

	
}
