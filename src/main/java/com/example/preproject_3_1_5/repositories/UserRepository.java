package com.example.preproject_3_1_5.repositories;

import com.example.preproject_3_1_5.entities.User;

import java.util.List;


public interface UserRepository {
    User findByUsername(String username);

    List<User> getAllUsers();

    void add(User user);

    void removeUserById(Long id);


    void edit(User user);

    User getUserById(Long id);


}
