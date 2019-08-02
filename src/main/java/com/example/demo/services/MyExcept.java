package com.example.demo.services;

public class MyExcept extends RuntimeException {
    public MyExcept(String not_present) {
        super(not_present);
    }
}
