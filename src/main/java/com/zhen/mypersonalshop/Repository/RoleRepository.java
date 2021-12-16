package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {


}
