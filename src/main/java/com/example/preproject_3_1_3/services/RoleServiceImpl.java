package com.example.preproject_3_1_3.services;

import com.example.preproject_3_1_3.entities.Role;
import com.example.preproject_3_1_3.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
   private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
// @PostConstruct
// @Transactional
// public void init(){
//        roleRepository.add(new Role("ROLE_USER"));
  //      roleRepository.add(new Role("ROLE_ADMIN"));
// }
    @Override
    public List<Role> getRoleList() {
        return roleRepository.getAllRoles();
    }
}
