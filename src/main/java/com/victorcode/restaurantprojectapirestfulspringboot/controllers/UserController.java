package com.victorcode.restaurantprojectapirestfulspringboot.controllers;

import com.victorcode.restaurantprojectapirestfulspringboot.dtos.UserRecordDTO;
import com.victorcode.restaurantprojectapirestfulspringboot.models.UserModel;
import com.victorcode.restaurantprojectapirestfulspringboot.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserModel> registerUser(@Valid @RequestBody UserRecordDTO userRecordDTO) {
        UserModel createdUser = userService.saveUser(userRecordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(createdUser);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable UUID id) {
        Optional<UserModel> userOp = userService.getUserById(id);
        if(userOp.isPresent()) {
            return ResponseEntity.ok(userOp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
