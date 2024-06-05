package com.victorcode.restaurantprojectapirestfulspringboot.services;

import com.victorcode.restaurantprojectapirestfulspringboot.dtos.UserRecordDTO;
import com.victorcode.restaurantprojectapirestfulspringboot.exceptions.EmailFoundException;
import com.victorcode.restaurantprojectapirestfulspringboot.models.UserModel;
import com.victorcode.restaurantprojectapirestfulspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel saveUser(UserRecordDTO userRecordDTO) {
        try {
            UserModel userModel = new UserModel();
            userModel.setUserName(userRecordDTO.userName());
            userModel.setUserEmail(userRecordDTO.userEmail());
            userModel.setUserPassword(userRecordDTO.userPassword());

            if (userRepository.findByUserEmail(userRecordDTO.userEmail()).isPresent()) {
                throw new EmailFoundException();
            }

            return userRepository.save(userModel);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save user.");
        }
    }

    public Optional<UserModel> getUserById(UUID id) {
        return userRepository.findById(id);
    }

}
