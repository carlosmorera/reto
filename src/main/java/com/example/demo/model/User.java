package com.example.demo.model;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String documentNumber;
    private String documentType;
    private String firstName;
    private String secondName;
    private String lastName;
    private String middleLastName;
    private String phone;
    private String address;
    private String residence;
}
