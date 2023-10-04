package com.example.preproject_3_1_3.entities;

public class UserData {
    private Long id;
    private String username;

    private String surname;
    private String password;
    private Long roles;

    public UserData() {}

    public UserData(String username, String surname, String password, Long roles) {
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.roles = roles;
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
        return roles;
    }

    public void setRoles(Long roles) {
        this.roles = roles;
    }


}
