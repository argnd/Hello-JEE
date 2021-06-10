package com.hellojee.Hello_JavaEE.entity;

public abstract class JpaEntity {
    private Class aClass;

    public JpaEntity(Class aClass) {
        this.aClass = aClass;
    }

    public Class getaClass(){
        return aClass;
    }

    public abstract long getId();

}
