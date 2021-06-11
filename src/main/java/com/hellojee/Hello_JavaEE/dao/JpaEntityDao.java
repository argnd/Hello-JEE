package com.hellojee.Hello_JavaEE.dao;

import com.hellojee.Hello_JavaEE.entity.JpaReflectiveEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
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
    public List<T> findAll(T jpaReflectiveEntity) {
        List<T>  l;
        Query query = em.createQuery("SELECT e FROM "+jpaReflectiveEntity.getaClass().getName()+" e");
        l = (List<T>) query.getResultList();
        return l;
    }

    @Override
    public void remove(T jpaReflectiveEntity) {

    }

}

