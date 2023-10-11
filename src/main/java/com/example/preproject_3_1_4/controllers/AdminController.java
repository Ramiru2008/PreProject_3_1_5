package com.example.preproject_3_1_4.controllers;

import com.example.preproject_3_1_4.dto.UserDto;
import com.example.preproject_3_1_4.entities.Role;
import com.example.preproject_3_1_4.entities.User;
import com.example.preproject_3_1_4.services.RoleService;
import com.example.preproject_3_1_4.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String show(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String registration(Model model) {
        User user = new User();
        Collection<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") UserDto userDto, @RequestParam("roles") List<Long> roleIds) {
        List<Role> roles = roleService.getRoleByIds(userDto.getRoles());
        if (userService.findByUsername(userDto.getUsername()) == null) {
            User user = new User(
                    userDto.getUsername(),
                    userDto.getSurname(),
                    userDto.getPassword(),
                    new HashSet<>(roles)
            );
            userService.add(user);
        } else {
            return "redirect: /admin/login";
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") UserDto userDto) {
        User user = userService.findByUsername(userDto.getUsername());
        List<Role> roles = roleService.getRoleByIds(userDto.getRoles());

        Set<Role> setRoles = new HashSet<>(roles);
        user.setRoles(setRoles);
        user.setPassword(userDto.getPassword());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        userService.edit(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin/users/";
    }
}
