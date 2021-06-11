package com.hellojee.Hello_JavaEE.dao;

import com.hellojee.Hello_JavaEE.entity.JpaReflectiveEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class JpaEntityDao<T extends JpaReflectiveEntity> implements CrudDao<T> {

    private final EntityManager em;

    public JpaEntityDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    public boolean create(T jpaReflectiveEntity) {
        this.em.getTransaction().begin();
        this.em.persist(jpaReflectiveEntity);
        this.em.getTransaction().commit();
        boolean tmp = this.em.contains(jpaReflectiveEntity);
        this.em.close();

        return tmp;
    }

    @Override
    public void update(T jpaReflectiveEntity) {

    }

    @Override
    public T findById(T jpaReflectiveEntity) {
        return (T) this.em.find(jpaReflectiveEntity.getaClass(), jpaReflectiveEntity.getId());
    }

    @Override
    public List<T> findAll(T jpaReflectiveEntity) {
        List<T>  l;
        Query query = this.em.createQuery("SELECT e FROM "+jpaReflectiveEntity.getaClass().getName()+" e");
        l = (List<T>) query.getResultList();
        this.em.close();
        return l;
    }

    @Override
    public void remove(T jpaReflectiveEntity) {
        JpaReflectiveEntity j = findById(jpaReflectiveEntity);
        System.out.println(j.getaClass());
        if (j.getId() != null){
            this.em.getTransaction().begin();
            this.em.remove(j);
            this.em.getTransaction().commit();
        }
    }

}

