package com.example.preproject_3_1_3.repositories;

import com.example.preproject_3_1_3.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    User findByUsername (String username);
    List<User> getAllUsers();

    void add(User user);

    void removeUserById(Long id);

    User getUserById(Long id);

    void edit(User user);
}
