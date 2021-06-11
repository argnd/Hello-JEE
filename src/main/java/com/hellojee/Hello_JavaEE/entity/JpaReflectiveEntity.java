package com.hellojee.Hello_JavaEE.entity;

public abstract class JpaReflectiveEntity {
    private final Class<? extends JpaReflectiveEntity> aClass;


    public JpaReflectiveEntity(Class<? extends JpaReflectiveEntity> aClass) {

        this.aClass = aClass;

    }

    public Class<? extends JpaReflectiveEntity> getaClass(){
        return aClass;
    }

    public abstract long getId();

}