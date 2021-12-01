package com.zhen.mypersonalshop.Model;


import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;

    @Column(name = "pass")
    private String password;

    @Column(unique = true)
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Item> shoppingCartList;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "cart",
            joinColumns = @JoinColumn(
                    name="user_id",
                    referencedColumnName = "id"
            )
    )
    Set<Item> itemSet;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JsonIgnore
//    @JoinTable(
//            name = "group_followers",
//            joinColumns = @JoinColumn(
//                    name = "user_id",
//                    referencedColumnName = "id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "group_chat_id",
//                    referencedColumnName = "id"
//            )
//    )

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
