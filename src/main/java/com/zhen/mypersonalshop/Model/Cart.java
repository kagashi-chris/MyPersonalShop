package com.zhen.mypersonalshop.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties(value = "cart", allowSetters = true)
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = "cart", allowSetters = true)
    private User user;

    @Column(name = "amount")
    private int amount;

    public Cart() {
    }

    public Cart(Product product, User user, int amount) {
        this.product = product;
        this.user = user;
        this.amount = amount;
    }

    public Cart(int id, Product product, User user, int amount) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                ", amount=" + amount +
                '}';
    }

//    @Override
//    public boolean equals(Object o)
//    {
//        if(this == o)
//        {
//            return true;
//        }
//        if(o == null || getClass() != o.getClass())
//        {
//            return false;
//        }
//
//
//    }
}
