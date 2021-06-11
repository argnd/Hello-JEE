package com.hellojee.Hello_JavaEE.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Categories")
public class Category extends JpaReflectiveEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<OtherProduct> otherProducts;

    public List<OtherProduct> getProd() {
        return otherProducts;
    }

    public void setProd(List<OtherProduct> prod) {
        this.otherProducts = prod;
    }

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
