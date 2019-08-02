package com.example.demo.controllers;


import com.example.demo.entities.Dog;
import com.example.demo.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/dog")
public class DogController
{

    private DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/create")
    public Dog createRequestDog(@RequestParam String name,
                              @RequestParam int age,
                              @RequestParam String gender,
                              @RequestParam boolean sterilized,
                              @RequestParam int breedId)
    {
        return dogService.createDog(name, age, gender,sterilized,breedId);
    }

}
