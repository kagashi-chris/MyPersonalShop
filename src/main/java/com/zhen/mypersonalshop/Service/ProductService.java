package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    public Product saveOrCreateProduct(Product product);
    public Optional<Product> getProduct(long id);
    public Iterable<Product> getAllProducts();
    public void deleteProduct(long id);


}
