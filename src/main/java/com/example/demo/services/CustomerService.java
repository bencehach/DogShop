package com.example.demo.services;


import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String firstName, String lastName, int age, boolean nebunLaCap) {

        Customer createdCustomer = Customer.builder().firstName(firstName)
                .lastName(lastName)
                .age(age)
                .nebunLaCap(nebunLaCap)
                .build();

        customerRepository.save(createdCustomer);

        return createdCustomer;
    }

    public Customer getCustomerByID(int id) throws MyExcept {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent())
            return customer.get();
        else throw new MyExcept("not present");
    }

    public void deleteCustomerById(int userId) throws MyExcept {
        customerRepository.deleteById(userId);
    }
}