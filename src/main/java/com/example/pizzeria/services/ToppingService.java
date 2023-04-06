package com.example.pizzeria.services;

import com.example.pizzeria.entities.Topping;
import com.example.pizzeria.repositories.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {

    private ToppingRepository toppingRepository;

    @Autowired
    public ToppingService(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    public List<Topping> findAll() {
        return (List<Topping>) toppingRepository.findAll();
    }
}
