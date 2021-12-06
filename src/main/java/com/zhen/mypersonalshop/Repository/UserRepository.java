package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}


