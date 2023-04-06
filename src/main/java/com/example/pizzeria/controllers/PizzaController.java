package com.example.pizzeria.controllers;

import com.example.pizzeria.entities.Topping;
import com.example.pizzeria.entities.User;
import com.example.pizzeria.services.ToppingService;
import com.example.pizzeria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

    private ToppingService toppingService;
    private UserService userService;

    @Autowired
    public PizzaController(ToppingService toppingService, UserService userService) {
        this.toppingService = toppingService;
        this.userService = userService;
    }

    @GetMapping
    public String showPizzaForm(Model model) {
        List<Topping> toppings = new ArrayList<>(toppingService.findAll());
        model.addAttribute("toppings", toppings);
        model.addAttribute("user", new User());
        return "pizza";
    }

    @PostMapping
    public String processPizza(User user) {
        User existedUser = userService.findUserByEmail(user.getEmail());
        if (existedUser == null) {
            userService.saveUser(user);
        } else {
            existedUser.setToppings(user.getToppings());
            userService.saveUser(existedUser);
        }
        return "redirect:/pizza";
    }
}
