package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findRoleByName(String name);
}
