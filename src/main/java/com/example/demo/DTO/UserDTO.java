package com.example.demo.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Builder
public class UserDTO implements Serializable {


    private String documentNumber;
    private String documentType;



}
