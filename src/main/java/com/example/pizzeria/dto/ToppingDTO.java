package com.example.pizzeria.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ToppingDTO implements Serializable {
    private Long id;

    private String name;
}
