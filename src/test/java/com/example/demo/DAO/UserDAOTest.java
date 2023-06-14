package com.example.demo.DAO;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDAOTest {


    UserDAO userDAO = new UserDAO();

    @Test
    void shouldAddUser() {
        User userTest = User.builder()
                .firstName("Andres")
                .secondName("Felipe")
                .lastName("Perez")
                .middleLastName("Ramirez")
                .phone("1234567")
                .address("calle falsa 1234")
                .residence("Bogota")
                .build();
        Optional<User> userOptional = userDAO.add(userTest);
        assertTrue(userOptional.isPresent());

    }
}
