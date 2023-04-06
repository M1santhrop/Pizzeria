package com.example.pizzeria.controller;

import com.example.pizzeria.dto.UserDTO;
import com.example.pizzeria.service.ToppingService;
import com.example.pizzeria.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/toppings")
public class ToppingController {

    private final ToppingService toppingService;
    private final UserService userService;

    public ToppingController(ToppingService toppingService, UserService userService) {
        this.toppingService = toppingService;
        this.userService = userService;
    }

    @GetMapping
    public String showToppingsForm(Model model) {
        model.addAttribute("toppings", toppingService.findAll());
        model.addAttribute("user", new UserDTO());
        return "toppings";
    }

    @PostMapping
    public String processToppings(@ModelAttribute("user") UserDTO userDTO) {
        userService.processToppings(userDTO);
        return "redirect:/toppings";
    }

    @GetMapping("/count")
    public String showToppingsCount(Model model) {
        Map<String, Long> countToppings = userService.countToppings();
        model.addAttribute("toppingsCount", countToppings);
        return "toppingsCount";
    }
}
