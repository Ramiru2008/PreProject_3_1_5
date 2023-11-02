package com.example.preproject_3_1_5.repositories;

import com.example.preproject_3_1_5.entities.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> getAllRoles() {
        return em.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public void add(Role role) {
        em.persist(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return em.find(Role.class, id);
    }

    @Override
    public List<Role> getRoleByIds(List<Long> roleIds) {
        return em.createQuery("select r from Role r where r.id in ?1", Role.class)
                .setParameter(1, roleIds)
                .getResultList();
    }
}
