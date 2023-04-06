package com.example.pizzeria.service;

import com.example.pizzeria.dto.ToppingDTO;
import com.example.pizzeria.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, Long> countToppings();

    List<ToppingDTO> getToppings(UserDTO userDTO);

    void processToppings(UserDTO userDTO);
}
