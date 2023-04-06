package com.example.pizzeria.controller;

import com.example.pizzeria.dto.ToppingDTO;
import com.example.pizzeria.dto.UserDTO;
import com.example.pizzeria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserChoice(Model model) {
        model.addAttribute("user", new UserDTO());
        return "userChoice";
    }

    @PostMapping
    public String processEmail(Model model, UserDTO userDTO) {
        List<ToppingDTO> toppingDTOs = userService.getToppings(userDTO);
        model.addAttribute("user", userDTO);
        model.addAttribute("toppings", toppingDTOs);
        return "userChoice";
    }
}
