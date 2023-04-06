package com.example.pizzeria.service.impl;

import com.example.pizzeria.dto.ToppingDTO;
import com.example.pizzeria.entity.Topping;
import com.example.pizzeria.repository.ToppingRepository;
import com.example.pizzeria.service.ToppingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.example.pizzeria.converter.ToppingConverter.convertToppingsToToppingDTOs;
import static org.junit.jupiter.api.Assertions.*;

class ToppingServiceImplTest {

    private final ToppingRepository toppingRepository = Mockito.mock(ToppingRepository.class);

    private ToppingService toppingService;

    @BeforeEach
    void setup() {
        toppingService = new ToppingServiceImpl(toppingRepository);
    }

    @Test
    void findAll() {
        Mockito.when(toppingRepository.findAll()).thenReturn(buildToppings());

        List<ToppingDTO> toppingDTOS = toppingService.findAll();

        assertEquals(3, toppingDTOS.size());
        assertEquals(convertToppingsToToppingDTOs(buildToppings()), toppingDTOS);
    }

    public static Collection<Topping> buildToppings() {
        Topping topping1 = new Topping();
        topping1.setId(1L);
        topping1.setName("Name 1");
        Topping topping2 = new Topping();
        topping2.setId(2L);
        topping2.setName("Name 2");
        Topping topping3 = new Topping();
        topping3.setId(3L);
        topping3.setName("Name 3");

        return new ArrayList<>(List.of(topping1, topping2, topping3));
    }
}