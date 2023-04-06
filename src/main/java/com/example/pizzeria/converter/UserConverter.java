package com.example.pizzeria.converter;

import com.example.pizzeria.dto.UserDTO;
import com.example.pizzeria.entity.Topping;
import com.example.pizzeria.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static User convertUserDTOToUser(UserDTO userDTO, Set<Topping> toppings) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setToppings(toppings);
        return user;
    }
}
