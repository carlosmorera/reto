package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {
    private String firstName;
    private String secondName;
    private String lastName;
    private String middleLastName;
    private String phone;
    private String address;
    private String residence;
}
