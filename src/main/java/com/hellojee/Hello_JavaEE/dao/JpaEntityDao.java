package com.hellojee.Hello_JavaEE.dao;

import com.hellojee.Hello_JavaEE.entity.JpaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaEntityDao<T extends JpaEntity> implements CrudDao<T> {

    private EntityManager em = null;

    public JpaEntityDao(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    public boolean create(T jpaentity) {
        em.getTransaction().begin();
        em.persist(jpaentity);
        em.getTransaction().commit();
        boolean tmp = em.contains(jpaentity);
        em.close();

        return tmp;
    }

    @Override
    public void update(T jpaentity) {

    }

    @Override
    public T findById(T jpaentity) {
        return (T) em.find(jpaentity.getaClass(), jpaentity.getId());
//        return em.find(Category.class, jpaentity.getId());
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void remove(T jpaentity) {

    }

    @Override
    public void removeById(Long id) {

    }
}

