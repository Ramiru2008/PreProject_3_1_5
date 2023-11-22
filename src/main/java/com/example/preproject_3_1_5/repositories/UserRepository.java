package com.example.preproject_3_1_5.repositories;

import com.example.preproject_3_1_5.entities.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User findByUsername(String username);

    User getUserById(long id);
}
