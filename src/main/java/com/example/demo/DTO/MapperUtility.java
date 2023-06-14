package com.example.demo.DTO;


import com.example.demo.model.User;
import com.example.demo.model.UserResponse;

public final class MapperUtility {


    public static User buildUserFromDto(UserDTO userDTO) {
        return User.builder()
                .documentNumber(userDTO.getDocumentNumber())
                .documentType(userDTO.getDocumentType())
                .firstName("Andres")
                .secondName("Felipe")
                .lastName("Perez")
                .middleLastName("Ramirez")
                .phone("1234567")
                .address("calle falsa 1234")
                .residence("Bogota")
                .build();
    }
    public static UserResponse buildUserResponse() {
        return UserResponse.builder()
                .firstName("Andres")
                .secondName("Felipe")
                .lastName("Perez")
                .middleLastName("Ramirez")
                .phone("1234567")
                .address("calle falsa 1234")
                .residence("Bogota")
                .build();
    }


}
