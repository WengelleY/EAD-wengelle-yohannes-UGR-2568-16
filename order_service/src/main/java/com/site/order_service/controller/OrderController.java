package com.site.order_service.controller;

import com.site.order_service.dto.OrderDetailsResponse;
import com.site.order_service.model.Order;
import com.site.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/customer/{customerId}")
    public OrderDetailsResponse getOrderDetailsByCustomerId(
            @PathVariable String customerId) {

        return orderService.getOrderDetailsByCustomerId(customerId);
    }

    @GetMapping("/{orderId}/details")
    public OrderDetailsResponse getOrderDetailsById(
            @PathVariable Long orderId) {

        return orderService.getOrderDetailsById(orderId);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}