package com.example.preproject_3_1_3.repositories;

import com.example.preproject_3_1_3.entities.Role;
import com.example.preproject_3_1_3.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User findByUsername(String username) {
        return em
                .createQuery("Select u from User u left join fetch u.roles where u.username=:username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void removeUserById(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public void edit(User user, Role role) {
        em.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

}
