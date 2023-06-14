package com.example.demo.controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.model.MessageError;
import com.example.demo.model.User;
import com.example.demo.model.UserResponse;
import com.example.demo.service.IUserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/")public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("user")
    public ResponseEntity addUser( @RequestBody UserDTO user) throws Exception {
        Gson gson = new Gson();
        try {
            Optional<User> userSaved = userService.add(user);
            return userSaved.map(userFound -> new ResponseEntity<>("Se agrego satisfactoriamente el usuario: " + userFound.getDocumentNumber(), HttpStatus.CREATED))
                    .orElseGet(() -> new ResponseEntity<>(gson.toJson(new MessageError("User Not saved")), HttpStatus.INTERNAL_SERVER_ERROR));
        } catch (Exception e) {
            return new ResponseEntity<>(gson.toJson(new MessageError(e.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/user/{documentNumber}")
    public ResponseEntity getUser( @PathVariable String documentNumber) {
        Gson gson = new Gson();
        try {
            Optional<UserResponse> user = userService.getUserById(documentNumber);
            return user.map(userFound -> new ResponseEntity<>(gson.toJson(userFound), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(gson.toJson(new MessageError("User Not Fount")), HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(gson.toJson(new MessageError(e.getMessage())), HttpStatus.NOT_FOUND);
        }
    }

}
