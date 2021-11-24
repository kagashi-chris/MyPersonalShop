package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    <S extends User> S save(S entity);

    @Override
    <S extends User> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<User> findById(Integer integer);

    @Override
    Iterable<User> findAll();

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void deleteAll();
}


