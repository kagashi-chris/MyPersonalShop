package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    Role addRole(Role role);
    Role getRole(long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    Role updateRole(Role role);
    void deleteRole();
}
