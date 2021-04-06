package com.yetanotheruseless.industrycrashcourse.ecommerce.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long addOrder(Order order) {
        Order saved = orderRepository.save(order);
        return saved.getId();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByOrderid(Long id) {
        return orderRepository.findByOrderId(id);
    }
}
