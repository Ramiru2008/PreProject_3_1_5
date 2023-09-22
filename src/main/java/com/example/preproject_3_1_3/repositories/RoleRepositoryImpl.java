package com.example.preproject_3_1_3.repositories;

import com.example.preproject_3_1_3.entities.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
@Repository
public class RoleRepositoryImpl implements RoleRepository{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Role> getAllRoles() {
        return em.createQuery("from Role ", Role.class).getResultList();
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
    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = em
                    .createQuery("SELECT r FROM Role r WHERE r.name=:name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Роли с таким именем не существует!");
        }
        return role;
    }

    @Override
    public Set<Role> findByIdRoles(String name) {
        return null;
    }
}
