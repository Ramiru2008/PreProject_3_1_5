package com.example.preproject_3_1_4.dto;


import java.util.List;

public class UserDto {
    private Long id;
    private String username;

    private String surname;
    private String password;
    private Long role;
    private List<Long> roles;

    public UserDto() {
    }

    public UserDto(Long id, String username, String surname, String password, List<Long> roles) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.roles = roles;
    }

    public UserDto(String username, String surname, String password, Long role) {
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
    public List<Long> getRoles() {
        return roles;
    }
    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

}
