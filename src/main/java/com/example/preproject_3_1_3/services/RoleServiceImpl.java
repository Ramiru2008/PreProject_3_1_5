package com.example.preproject_3_1_3.services;

import com.example.preproject_3_1_3.entities.Role;
import com.example.preproject_3_1_3.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> getRole = roleRepository.findById(id);
        return getRole.orElse(null);
    }
}
