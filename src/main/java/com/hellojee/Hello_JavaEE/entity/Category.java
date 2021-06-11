package com.hellojee.Hello_JavaEE.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Categories")
public class Category extends JpaReflectiveEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name")
    private String name;

    public Category(){
        super(Category.class);
    }

    public Long getId() {
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
