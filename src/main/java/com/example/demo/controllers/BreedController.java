package com.example.demo.controllers;


import com.example.demo.entities.Breed;
import com.example.demo.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/breed")
public class BreedController {
    private BreedService breedService;

    @Autowired
    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }

    @PostMapping("/create")
    public Breed createBreed(@RequestParam String breedName)
    {
        {
            return breedService.createBreed(breedName);
        }
    }
}
