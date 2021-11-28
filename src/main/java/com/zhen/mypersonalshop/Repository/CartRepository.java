package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<Item, Integer> {

    @Override
    <S extends Item> S save(S entity);

    @Override
    Optional<Item> findById(Integer integer);

    @Override
    Iterable<Item> findAll();

    @Override
    void deleteById(Integer integer);
}
