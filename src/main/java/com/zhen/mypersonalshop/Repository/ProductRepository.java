package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Override
    <S extends Product> S save(S entity);

    @Override
    Optional<Product> findById(Integer integer);

    @Override
    Iterable<Product> findAll();

    @Override
    void deleteById(Integer integer);
}
