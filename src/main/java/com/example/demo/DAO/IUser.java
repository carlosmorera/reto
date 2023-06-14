package com.example.demo.DAO;


import com.example.demo.model.User;

import java.util.Optional;

public interface IUser {
    public Optional<User>  add(User user);
}
