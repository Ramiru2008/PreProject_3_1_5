package com.example.preproject_3_1_5.services;

import com.example.preproject_3_1_5.entities.Role;

import java.util.List;


public interface RoleService {
    List<Role> getAllRoles();

    void add(Role role);

    Role getRoleById(Long id);

    List<Role> getRoleByIds(List<Long> roleIds);

}
