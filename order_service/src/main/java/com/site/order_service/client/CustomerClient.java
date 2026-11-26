package com.site.order_service.client;

import com.site.order_service.dto.CustomerResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CustomerClient {

    private final RestClient restClient;

    public CustomerClient(RestClient customerRestClient) {
        this.restClient = customerRestClient;
    }

    public CustomerResponse getCustomerById(String customerId) {

        return restClient.get()
                .uri("/api/customers/{id}", customerId)
                .retrieve()
                .body(CustomerResponse.class);
    }
}