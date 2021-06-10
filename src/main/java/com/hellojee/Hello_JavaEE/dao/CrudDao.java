package com.hellojee.Hello_JavaEE.dao;

import java.util.List;

public interface CrudDao<T> {

    boolean create(T jpaentity);

    void update(T jpaentity);

    T findById(T jpaentity);

    List<T> findAll();

    void remove(T jpaentity);

    void removeById(Long id);

}

