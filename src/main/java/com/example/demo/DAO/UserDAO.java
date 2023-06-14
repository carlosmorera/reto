package com.example.demo.DAO;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserDAO implements IUser {

    private Map<String, User> users = new HashMap<String, User>();

    @Override
    public Optional<User> add(User user) {
        users.put(user.getDocumentNumber(),user);
        return Optional.of(user);
    }

}
