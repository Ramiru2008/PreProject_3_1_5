package com.example.preproject_3_1_3.services;

import com.example.preproject_3_1_3.entities.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getRoleList();
    Set<Role> getByName (String name);
    void add (Role role);

    List<Role> getAll();

    void removeById(Long id);
}
