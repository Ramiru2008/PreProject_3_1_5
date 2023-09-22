package com.example.preproject_3_1_3.sequrity;

import com.example.preproject_3_1_3.entities.Role;
import org.springframework.security.core.GrantedAuthority;

public class RoleDetail implements GrantedAuthority {
    private Role role;

    public RoleDetail(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role.getName();
    }
}
