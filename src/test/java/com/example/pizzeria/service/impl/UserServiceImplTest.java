package com.example.pizzeria.service.impl;

import com.example.pizzeria.dto.ToppingDTO;
import com.example.pizzeria.dto.UserDTO;
import com.example.pizzeria.entity.Topping;
import com.example.pizzeria.entity.User;
import com.example.pizzeria.repository.ToppingRepository;
import com.example.pizzeria.repository.UserRepository;
import com.example.pizzeria.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static com.example.pizzeria.service.impl.ToppingServiceImplTest.buildToppings;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final ToppingRepository toppingRepository = Mockito.mock(ToppingRepository.class);

    private UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserServiceImpl(userRepository, toppingRepository);
    }

    @Test
    void countToppings() {
        Mockito.when(userRepository.findAll()).thenReturn(buildUsers());

        Map<String, Long> countToppings = userService.countToppings();

        assertEquals(3, countToppings.size());
        assertEquals(3, countToppings.get("Name 1"));
        assertEquals(2, countToppings.get("Name 2"));
        assertEquals(1, countToppings.get("Name 3"));
    }

    @Test
    void getToppings() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setEmail("user@gmail.com");
        userDTO.setToppingIds(Set.of(1L, 2L, 3L));

        Mockito.when(userRepository.findUserByEmail("user@gmail.com")).thenReturn(buildUser());

        List<ToppingDTO> toppingDTOs = userService.getToppings(userDTO);

        assertEquals(3, toppingDTOs.size());
        toppingDTOs.forEach(toppingDTO -> assertTrue(userDTO.getToppingIds().contains(toppingDTO.getId())));
    }

    @Test
    void processToppingsForNewUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("user@gmail.com");
        userDTO.setToppingIds(Set.of(1L, 2L, 3L));

        Mockito.when(userRepository.findUserByEmail(userDTO.getEmail())).thenReturn(null);

        userService.processToppings(userDTO);

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    void processToppingsForExistedUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("user@gmail.com");
        userDTO.setToppingIds(Set.of(1L, 2L, 3L));

        Mockito.when(userRepository.findUserByEmail(userDTO.getEmail())).thenReturn(buildUser());

        userService.processToppings(userDTO);

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any());;
    }

    private User buildUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("user@gmail.com");
        user.setToppings(new HashSet<>(buildToppings()));
        return user;
    }

    private List<User> buildUsers() {
        Topping topping1 = new Topping();
        topping1.setName("Name 1");
        Topping topping2 = new Topping();
        topping2.setName("Name 2");
        Topping topping3 = new Topping();
        topping3.setName("Name 3");

        User user1 = new User();
        user1.setId(1L);
        user1.setEmail("user1@gmail.com");
        user1.setToppings(new HashSet<>(Set.of(topping1)));

        User user2 = new User();
        user2.setId(2L);
        user2.setEmail("user2@gmail.com");
        user2.setToppings(new HashSet<>(Set.of(topping1, topping2)));

        User user3 = new User();
        user3.setId(3L);
        user3.setEmail("user3@gmail.com");
        user3.setToppings(new HashSet<>(Set.of(topping1, topping2, topping3)));

        return new ArrayList<>(List.of(user1, user2, user3));
    }
}