package com.example.preproject_3_1_5.repositories;

import com.example.preproject_3_1_5.entities.Role;


import java.util.List;

public interface RoleRepository {
    List<Role> getAllRoles();

    void add(Role role);

    Role getRoleById(Long id);

    List<Role> getRoleByIds(List<Long> roleIds);

}
