package com.example.pizzeria.service.impl;

import com.example.pizzeria.dto.ToppingDTO;
import com.example.pizzeria.dto.UserDTO;
import com.example.pizzeria.entity.Topping;
import com.example.pizzeria.entity.User;
import com.example.pizzeria.repository.ToppingRepository;
import com.example.pizzeria.repository.UserRepository;
import com.example.pizzeria.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.pizzeria.converter.ToppingConverter.convertToppingsToToppingDTOs;
import static com.example.pizzeria.converter.UserConverter.convertUserDTOToUser;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ToppingRepository toppingRepository;

    public UserServiceImpl(UserRepository userRepository, ToppingRepository toppingRepository) {
        this.userRepository = userRepository;
        this.toppingRepository = toppingRepository;
    }

    @Override
    public Map<String, Long> countToppings() {
        List<User> users = (List<User>) userRepository.findAll();

        return users
                .stream()
                .distinct()
                .map(User::getToppings)
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(Topping::getName, Collectors.counting()));
    }

    @Override
    public List<ToppingDTO> getToppings(UserDTO userDTO) {
        User user = userRepository.findUserByEmail(userDTO.getEmail());
        return user != null ? convertToppingsToToppingDTOs(user.getToppings()) : Collections.emptyList();
    }

    @Override
    public void processToppings(UserDTO userDTO) {
        User existedUser = userRepository.findUserByEmail(userDTO.getEmail());
        Set<Topping> toppings = toppingRepository.findAllByIdIn(userDTO.getToppingIds());
        User user = convertUserDTOToUser(userDTO, toppings);
        if (existedUser == null) {
            userRepository.save(user);
        } else {
            existedUser.getToppings().clear();
            existedUser.getToppings().addAll(user.getToppings());
            userRepository.save(user);
        }
    }
}
