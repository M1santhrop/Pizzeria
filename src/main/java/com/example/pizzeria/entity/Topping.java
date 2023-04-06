package com.example.pizzeria.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table
public class Topping {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "topping_id")
    private Long id;

    @Column
    private String name;

    public Topping(String name) {
        this.name = name;
    }
}
