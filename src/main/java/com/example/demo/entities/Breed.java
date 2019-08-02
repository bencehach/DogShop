package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "dogList")
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String breedName;

    private int quantity;

    @JsonIgnore
    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL)
    private List<Dog> dogList;

    public void increaseQuantity()
    {
        this.quantity++;
    }

    public void decreaseQuantity()
    {
        this.quantity--;
    }

}
