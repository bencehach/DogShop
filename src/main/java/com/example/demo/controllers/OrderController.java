package com.example.demo.controllers;


import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
public class OrderController
{

        private OrderService orderService;


        @Autowired
        public OrderController(OrderService orderService) {
        this.orderService = orderService;
        }


    @PostMapping("/create")
    public Order createCustomer(
                                @RequestParam int customerId,
                                @RequestParam int dogId) {
        return orderService.createOrder(customerId,dogId);
    }


}
