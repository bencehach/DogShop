package com.example.demo.services;


import com.example.demo.entities.Customer;
import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private DogService dogService;
    private BreedService breedService;
    private CustomerService customerService;

    @Autowired
    public OrderService(OrderRepository orderRepository, DogService dogService, BreedService breedService, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.dogService = dogService;
        this.breedService = breedService;
        this.customerService = customerService;
    }

    public Order createOrder(int customerId, int dogId) {

        Order createdOrder = Order.builder().customer(customerService.getCustomerByID(customerId))
                                            .dog(dogService.getDogByID(dogId)).build();

        orderRepository.save(createdOrder);

        return createdOrder;

    }
}
