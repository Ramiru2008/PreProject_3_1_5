package com.example.preproject_3_1_5.repositories;


import com.example.preproject_3_1_5.entities.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> getAllRoles();

    Role getRole(String userRole);

    Role getRoleById(Long id);

    void addRole(Role role);

}
