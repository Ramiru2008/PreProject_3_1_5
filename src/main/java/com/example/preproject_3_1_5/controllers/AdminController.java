package com.example.preproject_3_1_5.controllers;

import com.example.preproject_3_1_5.exception_handling.NoSuchUserException;
import com.example.preproject_3_1_5.dto.UserDto;
import com.example.preproject_3_1_5.entities.Role;
import com.example.preproject_3_1_5.entities.User;
import com.example.preproject_3_1_5.services.RoleService;
import com.example.preproject_3_1_5.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public List<User> show() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody UserDto userDto) {
        List<Role> roles = roleService.getRoleByIds(userDto.getRoles());
            User user = new User(
                    userDto.getUsername(),
                    userDto.getFirstName(),
                    userDto.getLastName(),
                    userDto.getAge(),
                    userDto.getPassword(),
                    new HashSet<>(roles)
            );
            userService.add(user);
        return user;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no User with ID = " + id + " in Database");
        }
        return user;
    }


    @PutMapping("/users")
    public User editUser(@RequestBody UserDto userDto) {
        User user = userService.getUserById(userDto.getId());
        List<Role> roles = roleService.getRoleByIds(userDto.getRoles());
        Set<Role> setRoles = new HashSet<>(roles);
        user.setRoles(setRoles);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setAge(userDto.getAge());
        if (!userDto.getPassword().isEmpty()) {
       userService.edit(user);
        }
       return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);

        return "User with ID = " + id + " was deleted";
    }

}
