//package com.example.pizzeria.configs;
//
//import com.example.pizzeria.entities.Topping;
//import com.example.pizzeria.repositories.ToppingRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DevelopmentConfig {
//
//    @Bean
//    public CommandLineRunner dataLoader(ToppingRepository toppingRepository) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                toppingRepository.deleteAll();
//
//                toppingRepository.save(new Topping("Pepperoni"));
//                toppingRepository.save(new Topping("Mushroom"));
//                toppingRepository.save(new Topping("Extra cheese"));
//                toppingRepository.save(new Topping("Sausage"));
//                toppingRepository.save(new Topping("Onion"));
//                toppingRepository.save(new Topping("Black olives"));
//                toppingRepository.save(new Topping("Green pepper"));
//                toppingRepository.save(new Topping("Fresh garlic"));
//                toppingRepository.save(new Topping("Tomato"));
//                toppingRepository.save(new Topping("Fresh basil"));
//            }
//        };
//    }
//}
