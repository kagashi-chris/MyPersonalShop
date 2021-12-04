package com.zhen.mypersonalshop.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="products")
public class Product {

    @Id
    private int id;

    @Column(unique = true, name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "product")
    Set<Cart> cart;

    public Product() {
    }

    public String getproductName() {
        return productName;
    }

    public void setproductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
