package com.site.order_service.dto;

import com.site.order_service.model.Order;

public class OrderDetailsResponse {

    private Order order;
    private CustomerResponse customer;

    public OrderDetailsResponse() {
    }

    public OrderDetailsResponse(Order order, CustomerResponse customer) {
        this.order = order;
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }
}