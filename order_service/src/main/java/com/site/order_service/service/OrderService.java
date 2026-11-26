package com.site.order_service.service;

import com.site.order_service.client.CustomerClient;
import com.site.order_service.dto.CustomerResponse;
import com.site.order_service.dto.OrderDetailsResponse;
import com.site.order_service.model.Order;
import com.site.order_service.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    public OrderService(
            OrderRepository orderRepository,
            CustomerClient customerClient) {

        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
    }

    public Order createOrder(Order order) {

        CustomerResponse customer =
                customerClient.getCustomerById(order.getCustomerId());

        if (customer == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer not found");
        }

        Optional<Order> existingOrder =
                orderRepository.findByCustomerId(order.getCustomerId());

        if (existingOrder.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This customer already has an order");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public OrderDetailsResponse getOrderDetailsById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Order not found"));

        CustomerResponse customer =
                customerClient.getCustomerById(order.getCustomerId());

        return new OrderDetailsResponse(order, customer);
    }

    public OrderDetailsResponse getOrderDetailsByCustomerId(String customerId) {

        Order order = orderRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Order not found"));

        CustomerResponse customer =
                customerClient.getCustomerById(customerId);

        return new OrderDetailsResponse(order, customer);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}