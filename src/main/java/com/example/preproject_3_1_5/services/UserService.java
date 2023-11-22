package com.example.preproject_3_1_5.services;

import com.example.preproject_3_1_5.entities.User;

import javax.validation.Valid;
import java.util.List;


public interface UserService {
    void add(User user);

    void edit(@Valid User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User findByUsername(String username);

    User getUserById(long id);
}