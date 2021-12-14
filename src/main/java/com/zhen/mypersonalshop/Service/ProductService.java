package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    Product saveOrCreateProduct(Product product);
    Optional<Product> getProduct(long id);
    Iterable<Product> getAllProducts();
    void deleteProduct(long id);


}
