package com.example.pizzeria.controllers;

import com.example.pizzeria.entities.Topping;
import com.example.pizzeria.entities.User;
import com.example.pizzeria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserChoice(Model model) {
        model.addAttribute("user", new User());
        return "userChoice";
    }

    @PostMapping
    public String processEmail(Model model, User user) {
        Set<Topping> toppings = userService.getToppings(user);
        model.addAttribute("toppings", toppings);
        return "userChoice";
    }
}
