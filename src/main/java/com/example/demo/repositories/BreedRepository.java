package com.example.demo.repositories;

import com.example.demo.entities.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed,Integer> {
}
