package com.example.preproject_3_1_3.services;

import com.example.preproject_3_1_3.entities.Role;
import com.example.preproject_3_1_3.entities.User;
import com.example.preproject_3_1_3.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {
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
        Optional<User> getUser = Optional.ofNullable(userRepository.getUserById(id));

        return getUser.orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> getUsername = Optional.ofNullable(userRepository.findByUsername(username));
        return getUsername.orElse(null);
    }

    @Override
    @Transactional
    public void removeUserById(Long id) {
        userRepository.removeUserById(id);
    }

    @Override
    @Transactional
    public void edit(User user, Role role) {
        userRepository.edit(user, role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
