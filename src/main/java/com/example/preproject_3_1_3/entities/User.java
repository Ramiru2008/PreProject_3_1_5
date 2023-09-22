package com.example.preproject_3_1_3.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
    @Table(name = "users")
    public class User {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(name = "username")
        private String username;

        @Column(name = "surname")
        private String surname;
        @Column(name = "password")
        private String password;
        @ManyToMany
        @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Collection<Role> roles;


        public User() {

        }

        public User(String username, String surname, String password) {

            this.username = username;
            this.surname = surname;
            this.password = password;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return username;
        }

        public void setName(String name) {
            this.username = name;
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

        public void setPassword(String  password) {
            this.password = password;
        }
}
