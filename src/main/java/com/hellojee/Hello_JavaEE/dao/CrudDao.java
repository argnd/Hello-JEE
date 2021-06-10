package com.hellojee.Hello_JavaEE.dao;

import java.util.List;

public interface CrudDao<T> {

    boolean create(T jpaentity);

    void update(T jpaentity);

    T findById(Long id);

    List<T> findAll();

    void remove(T jpaentity);

    void removeById(Long id);

}

