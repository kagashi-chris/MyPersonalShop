package com.zhen.mypersonalshop.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class Product {

    @Id
    private int id;
    private int amount;
    private String itemName;
    private int cost;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Product() {
    }

    public Product(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", amount=" + amount +
                ", itemName='" + itemName + '\'' +
                ", cost=" + cost +
                ", user=" + user +
                '}';
    }
}
