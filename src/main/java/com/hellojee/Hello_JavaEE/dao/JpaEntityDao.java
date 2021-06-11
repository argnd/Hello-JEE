package com.hellojee.Hello_JavaEE.dao;

import com.hellojee.Hello_JavaEE.entity.JpaReflectiveEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaEntityDao<T extends JpaReflectiveEntity> implements CrudDao<T> {

    private EntityManager em = null;

    public JpaEntityDao(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    public boolean create(T jpaReflectiveEntity) {
        em.getTransaction().begin();
        em.persist(jpaReflectiveEntity);
        em.getTransaction().commit();
        boolean tmp = em.contains(jpaReflectiveEntity);
        em.close();

        return tmp;
    }

    @Override
    public void update(T jpaReflectiveEntity) {

    }

    @Override
    public T findById(T jpaReflectiveEntity) {
        return (T) em.find(jpaReflectiveEntity.getaClass(), jpaReflectiveEntity.getId());
    }

    @Override
    public List<T> findAll() {

        return null;
    }

    @Override
    public void remove(T jpaReflectiveEntity) {

    }

}

