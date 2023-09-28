package com.example.preproject_3_1_3.repositories;

import com.example.preproject_3_1_3.entities.Role;


import java.util.List;

public interface RoleRepository {
    List<Role> getAllRoles();

    void add(Role role);

    Role getRoleById(Long id);
}
