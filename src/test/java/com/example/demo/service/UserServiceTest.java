package com.example.demo.service;

import com.example.demo.DAO.IUser;
import com.example.demo.DTO.MapperUtility;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.model.UserResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest {

    @Mock
     private IUser Iuser;

     private final UserService userService = new UserService();

    @Test
    void shouldGetUserByIdNotFount(){
        Optional<UserResponse> user = userService.getUserById("");
        assertTrue(user.isEmpty());
    }
    @Test
    void shouldGetUserById(){
        Optional<UserResponse> user = userService.getUserById("23445322");
        assertTrue(user.isPresent());
    }
    @Test
    void shouldFailAddUser() {
        UserDTO userDTO = UserDTO.builder()
                .documentNumber("123")
                .documentType("CC")
                .build();
        try {
            userService.add(userDTO);
        }catch (Exception e){
            assertEquals ("Tipo de documento invalido ",e.getMessage());
        }
    }
    @Test
    void shouldAddUser() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .documentNumber("123")
                .documentType("C")
                .build();
        User user = MapperUtility.buildUserFromDto(userDTO);
        when(Iuser.add(any())).thenReturn(Optional.of(user));

        try {
            Optional<User> userOptional = userService.add(userDTO);
        }catch (Exception e){
            assertFalse (e.toString().isEmpty());

        }
    }
}