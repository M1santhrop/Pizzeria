package com.example.pizzeria.controllers;

import com.example.pizzeria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/topping")
public class ToppingController {

    private final UserService userService;

    @Autowired
    public ToppingController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showToppings(Model model) {
        Map<String, Long> countToppings = userService.countToppings();
        model.addAttribute("toppings", countToppings);
        return "toppings";
    }
}
