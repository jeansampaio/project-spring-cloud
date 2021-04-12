package com.wysoft.api.order.repository;

import com.wysoft.api.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {}
