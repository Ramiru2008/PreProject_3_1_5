package com.example.preproject_3_1_4.services;

import com.example.preproject_3_1_4.entities.Role;

import java.util.List;


public interface RoleService {
    List<Role> getAllRoles();

    void add(Role role);

    Role getRoleById(Long id);
}
