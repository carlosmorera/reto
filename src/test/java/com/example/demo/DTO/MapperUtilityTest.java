package com.example.demo.DTO;

import com.example.demo.model.User;
import com.example.demo.model.UserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapperUtilityTest {

    @Test
    void shouldBuildUserFromDto(){
        UserDTO userDTO = UserDTO.builder()
                .documentNumber("123")
                .documentType("C")
                .build();
        User user = MapperUtility.buildUserFromDto(userDTO);
        assertEquals(userDTO.getDocumentNumber(),user.getDocumentNumber());
        assertEquals(userDTO.getDocumentType(),user.getDocumentType());
    }
    @Test
    void shouldBuildUserResponse(){
        UserResponse userResponse = MapperUtility.buildUserResponse();
        assertFalse(userResponse.getFirstName().isEmpty());
        assertFalse(userResponse.getSecondName().isEmpty());
        assertFalse(userResponse.getLastName().isEmpty());
        assertFalse(userResponse.getMiddleLastName().isEmpty());
    }
}
