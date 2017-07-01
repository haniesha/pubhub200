package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByOrderByIdDesc();

	List<Order> findByUserIdOrderByIdDesc(int id);

}
