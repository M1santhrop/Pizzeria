package com.example.pizzeria.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long id;

    private String email;

    private Set<Long> toppingIds;
}
