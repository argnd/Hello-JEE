package com.hellojee.Hello_JavaEE.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Categories")
public class Category extends JpaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="Name")
    private String name;

    public Category(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
