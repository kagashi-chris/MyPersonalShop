package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.Cart;
import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

}
