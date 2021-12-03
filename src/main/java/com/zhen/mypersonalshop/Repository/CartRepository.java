package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    @Override
    <S extends Cart> S save(S entity);

    @Override
    Optional<Cart> findById(Integer integer);

    @Override
    Iterable<Cart> findAll();

    @Override
    Iterable<Cart> findAllById(Iterable<Integer> integers);



    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Cart> entities);
}
