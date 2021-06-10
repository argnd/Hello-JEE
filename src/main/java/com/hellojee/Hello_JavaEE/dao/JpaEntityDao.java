package com.hellojee.Hello_JavaEE.dao;

import com.hellojee.Hello_JavaEE.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaEntityDao implements CrudDao<Category> {

    private static EntityManager em;

    public JpaEntityDao(EntityManagerFactory emf) {
        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    public boolean create(Category c) {
        c.setName("Hello");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        boolean  tmp = em.contains(c);
        em.close();
        return tmp;
    }

    @Override
    public void update(Category c) {

    }
    
    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public void remove(Category c) {

    }

    @Override
    public void removeById(Long id) {

    }
}

