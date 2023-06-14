package com.example.demo.service;


import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.model.UserResponse;

import java.util.Optional;

public interface IUserService {

    public Optional<UserResponse> getUserById(String documentNumber);

    public  Optional<User> add(UserDTO user) throws Exception;


}
