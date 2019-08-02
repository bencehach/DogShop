package com.example.demo.controllers;


import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import com.example.demo.services.MyExcept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer")

public class CustomerController {


    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/create")
    public Customer createCustomer(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int age,
                                   @RequestParam boolean nebunLaCap) {
        return customerService.createCustomer(firstName, lastName, age, nebunLaCap);
    }

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam int userId) throws MyExcept {
        return customerService.getCustomerByID(userId);
    }

    @DeleteMapping("/delete")
    public void deleteCustomer(@RequestParam int userId) throws MyExcept {
        try {
            customerService.deleteCustomerById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new MyExcept("Nu exista userul cu id-ul: " + userId);
        }
    }
}
