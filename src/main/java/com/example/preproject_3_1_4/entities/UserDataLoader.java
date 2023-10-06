package com.example.preproject_3_1_4.entities;

import com.example.preproject_3_1_4.repositories.RoleRepository;
import com.example.preproject_3_1_4.repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
 @Component
    public class UserDataLoader implements ApplicationRunner {

        private final UserRepository userRepository;
        private final RoleRepository roleRepository;

        public UserDataLoader(UserRepository userRepository, RoleRepository roleRepository) {
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;

        }


     @Override
     @Transactional
     public void run(ApplicationArguments args) throws Exception {
            Set<Role> roles = new HashSet<>();
         Role role = new Role(1L, "ROLE_ADMIN");
         roles.add(role);
         User user = new User("Roman", "Kudasov", "123", roles);
         userRepository.add(user);


         Set<Role> roles1 = new HashSet<>();
         Role role1 = new Role(2L, "ROLE_USER");
         roles.add(role1);
         User user1 = new User("Corey", "Taylor", "111", roles1);
         userRepository.add(user1);

     }

 }

