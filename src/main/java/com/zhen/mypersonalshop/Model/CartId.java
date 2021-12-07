package com.zhen.mypersonalshop.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


//the cart object uses this class to create it's ID by using user id and product id.
@Embeddable
public class CartId implements Serializable {

    private long user;

    private long product;

    public CartId() {
    }

    public CartId(long user, long product) {
        this.user = user;
        this.product = product;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getProduct() {
        return product;
    }

    public void setProduct(long product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartId)) return false;
        CartId cartId = (CartId) o;
        return getUser() == cartId.getUser() && getProduct() == cartId.getProduct();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getProduct());
    }
}
