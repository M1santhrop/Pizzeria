package com.example.pizzeria.repository;

import com.example.pizzeria.entity.Topping;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ToppingRepository extends CrudRepository<Topping, Long> {
    Set<Topping> findAllByIdIn(Set<Long> ids);
}
