package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Product;
import com.zhen.mypersonalshop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveOrCreateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProduct(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
