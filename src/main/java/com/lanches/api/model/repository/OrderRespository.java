package com.lanches.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanches.api.model.Order;

@Repository
public interface OrderRespository extends JpaRepository<Order, Long>{

}
