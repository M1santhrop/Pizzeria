package com.example.pizzeria.service;

import com.example.pizzeria.dto.ToppingDTO;

import java.util.List;

public interface ToppingService {
    List<ToppingDTO> findAll();
}
