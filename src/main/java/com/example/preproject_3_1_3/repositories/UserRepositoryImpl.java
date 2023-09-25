package com.example.preproject_3_1_3.repositories;

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
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void removeUserById(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public void edit(User user) {
        em.merge(user);
    }
    public User findByUsername(String username) {
        return em
                .createQuery(
                        "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username=:username", User.class
                )
                .setParameter("username", username)
                .getResultList()
                .stream().findFirst().orElse(null);
    }
}

}