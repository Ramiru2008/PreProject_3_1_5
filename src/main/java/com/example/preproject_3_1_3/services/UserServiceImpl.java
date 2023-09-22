package com.example.preproject_3_1_3.services;

import com.example.preproject_3_1_3.entities.User;
import com.example.preproject_3_1_3.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    @Transactional
    public void removeUserById(Long id) {
        userRepository.removeUserById(id);
    }

    @Override
    @Transactional
    public void edit(User user) {
        userRepository.edit(user);
    }
}
