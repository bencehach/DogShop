package com.example.demo.repositories;

import com.example.demo.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog,Integer> {
}
