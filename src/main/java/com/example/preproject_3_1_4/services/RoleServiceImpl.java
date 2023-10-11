package com.example.preproject_3_1_4.services;

import com.example.preproject_3_1_4.entities.Role;
import com.example.preproject_3_1_4.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleRepository.add(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }
    @Override
    public List<Role> getRoleByIds (List<Long> roleIds) {
        return roleRepository.getRoleByIds(roleIds);
    }

}

