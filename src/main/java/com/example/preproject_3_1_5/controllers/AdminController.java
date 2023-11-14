package com.example.preproject_3_1_5.controllers;

import com.example.preproject_3_1_5.dto.UserDto;
import com.example.preproject_3_1_5.entities.Role;
import com.example.preproject_3_1_5.entities.User;
import com.example.preproject_3_1_5.services.RoleService;
import com.example.preproject_3_1_5.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
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
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping("/users")
    public ResponseEntity<String> editUser(@RequestBody UserDto userDto) {
        User user = userService.getUserById(userDto.getId());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
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
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return new ResponseEntity<>("User with ID = " + id + " was deleted", HttpStatus.OK);
    }

}
