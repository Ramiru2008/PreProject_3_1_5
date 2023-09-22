package com.example.preproject_3_1_3.repositories;

import com.example.preproject_3_1_3.entities.Role;
import com.example.preproject_3_1_3.entities.User;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository {
    List<Role> getAllRoles();

    void add(Role role);

    Role getRoleById(Long id);

    Role getRoleByName(String name);
    Set<Role> findByIdRoles(String name);
}
