package com.example.demo.services;


import com.example.demo.entities.Breed;
import com.example.demo.repositories.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BreedService {

    private BreedRepository breedRepository;

    @Autowired
    public BreedService(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    public Breed createBreed(String breedName) {

        Breed createdBreed = Breed.builder().breedName(breedName)
                .quantity(0).build();
        breedRepository.save(createdBreed);
        return createdBreed;
    }

    public Breed getBreedByID(int id) throws MyExcept {
        Optional<Breed> breed = breedRepository.findById(id);
        if (breed.isPresent())
            return breed.get();
        else throw new MyExcept("not present");
    }


}
