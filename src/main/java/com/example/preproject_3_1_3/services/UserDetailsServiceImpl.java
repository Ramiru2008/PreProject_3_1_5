package com.example.preproject_3_1_3.services;

import com.example.preproject_3_1_3.entities.User;
import com.example.preproject_3_1_3.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
       if(user.isEmpty()) {
           throw new UsernameNotFoundException("User %s not found");
       }
       return (UserDetails) user.get();
}
}
