package com.example.pizzeria.repositories;

import com.example.pizzeria.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
}
