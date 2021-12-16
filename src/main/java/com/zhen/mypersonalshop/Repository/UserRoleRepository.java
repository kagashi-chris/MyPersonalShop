package com.zhen.mypersonalshop.Repository;

import com.zhen.mypersonalshop.Model.UserRole;
import com.zhen.mypersonalshop.Model.UserRoleId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UserRoleId> {
}
