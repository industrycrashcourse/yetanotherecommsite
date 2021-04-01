package com.yetanotheruseless.industrycrashcourse.ecommerce.Order;

import com.yetanotheruseless.industrycrashcourse.ecommerce.product.Product;
import com.yetanotheruseless.industrycrashcourse.ecommerce.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Order")
public class OrderController {

        private final OrderService orderService;

        @Autowired
        public OrderController(OrderService OrderService) {
            this.orderService = OrderService;
        }

        @GetMapping(path = "list")
        public List<Order> list() {
            return orderService.findAll();
        }

        @PostMapping
        public Long addOrder(@RequestBody Order order) {
            if (order.getName() == null) {
                // no way!  throw exception
            }
            return orderService.addOrder(order);
        }

}
