package com.hellojee.Hello_JavaEE.dao;

import java.util.List;

public interface CrudDao<T> {

    boolean create(T model);

    void update(T model);

    T findById(T model);

    List<T> findAll();

    void remove(T model);

}

