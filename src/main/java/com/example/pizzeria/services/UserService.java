package com.example.pizzeria.services;

import com.example.pizzeria.entities.Topping;
import com.example.pizzeria.entities.User;
import com.example.pizzeria.repositories.ToppingRepository;
import com.example.pizzeria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public Map<String, Long> countToppings() {
        List<User> users = (List<User>) userRepository.findAll();

        return users
                .stream()
                .distinct()
                .map(User::getToppings)
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(Topping::getName, Collectors.counting()));
    }

    public Set<Topping> getToppings(User user) {
        user = findUserByEmail(user.getEmail());
        return user != null ? user.getToppings() : Collections.emptySet();
    }
}
