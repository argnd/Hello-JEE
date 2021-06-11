package com.hellojee.Hello_JavaEE.entity;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Products")
public class OtherProduct extends JpaReflectiveEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name")
    private String name;
    @Column(name="Content")
    private String content;
    @Column(name="Price")
    private float price;
    @ManyToOne
    @JoinColumn(name="Category_fk")
    private Category category;

    public Category getCat() {
        return category;
    }

    public void setCat(Category cat) {
        this.category = cat;
    }

    public OtherProduct() {
        super(OtherProduct.class);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
