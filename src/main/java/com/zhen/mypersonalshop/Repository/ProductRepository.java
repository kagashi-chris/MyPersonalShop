package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
