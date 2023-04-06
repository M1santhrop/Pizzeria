package com.example.pizzeria.repositories;

import com.example.pizzeria.entities.Topping;
import org.springframework.data.repository.CrudRepository;

public interface ToppingRepository extends CrudRepository<Topping, Long> {
}
