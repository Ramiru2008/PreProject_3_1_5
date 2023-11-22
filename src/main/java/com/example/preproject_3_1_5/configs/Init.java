package com.example.preproject_3_1_5.configs;

import com.example.preproject_3_1_5.entities.Role;
import com.example.preproject_3_1_5.entities.User;
import com.example.preproject_3_1_5.services.RoleService;
import com.example.preproject_3_1_5.services.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initUser() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleAdmin);
        roleService.addRole(roleAdmin);

        Role roleUser = new Role("ROLE_USER");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);
        roleService.addRole(roleUser);

        User admin = new User("Roman", "Kudasov", 44, "rkudasov@gmail.com", "Ramiru2008", "123", adminRoles);
        userService.add(admin);

        User user = new User("Corey", "Taylor", 43,"slipknot@gmail.com", "Slipknot", "123", userRoles);
        userService.add(user);

    }
}
