package com.example.preproject_3_1_5.repositories;

import com.example.preproject_3_1_5.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> getAllRoles() {
        return em.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRole(String userRole) {
        return em.createQuery("select r from Role r where r.role =: userRole", Role.class)
                .setParameter("userRole", userRole).getSingleResult();
    }

    @Override
    public Role getRoleById(Long id) {
        return em.find(Role.class, id);
    }

    @Override
    public void addRole(Role role) {
        em.persist(role);
    }

}