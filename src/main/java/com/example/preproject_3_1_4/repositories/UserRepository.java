package com.example.preproject_3_1_4.repositories;

import com.example.preproject_3_1_4.entities.Role;
import com.example.preproject_3_1_4.entities.User;

import java.util.List;


public interface UserRepository {
    User findByUsername(String username);

    List<User> getAllUsers();

    void add(User user);

    void removeUserById(Long id);

    void edit(User user, Role role);

    User getUserById(Long id);


}
