package com.example.pizzeria.converter;

import com.example.pizzeria.dto.ToppingDTO;
import com.example.pizzeria.entity.Topping;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ToppingConverter {

    public static List<ToppingDTO> convertToppingsToToppingDTOs(Collection<Topping> toppings) {
        return toppings.stream()
                .map(ToppingConverter::convertToppingToToppingDTO)
                .collect(Collectors.toList());
    }

    public static ToppingDTO convertToppingToToppingDTO(Topping topping) {
        ToppingDTO toppingDTO = new ToppingDTO();
        toppingDTO.setId(topping.getId());
        toppingDTO.setName(topping.getName());
        return toppingDTO;
    }
}
