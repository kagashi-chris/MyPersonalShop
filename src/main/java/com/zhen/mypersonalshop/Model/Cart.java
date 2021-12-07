package com.zhen.mypersonalshop.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "carts")
@IdClass(CartId.class)
public class Cart implements Serializable {


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
                ", product=" + product +
                ", user=" + user +
                ", amount=" + amount +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return getProduct().equals(cart.getProduct()) && getUser().equals(cart.getUser());
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
