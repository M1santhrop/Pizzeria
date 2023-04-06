package com.example.pizzeria.service.impl;

import com.example.pizzeria.dto.ToppingDTO;
import com.example.pizzeria.entity.Topping;
import com.example.pizzeria.repository.ToppingRepository;
import com.example.pizzeria.service.ToppingService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.pizzeria.converter.ToppingConverter.convertToppingsToToppingDTOs;

@Service
public class ToppingServiceImpl implements ToppingService {

    private final ToppingRepository toppingRepository;

    public ToppingServiceImpl(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    @Override
    public List<ToppingDTO> findAll() {
        List<Topping> toppings = (List<Topping>) toppingRepository.findAll();
        return convertToppingsToToppingDTOs(toppings);
    }
}
