package com.zhen.mypersonalshop.Service;

import com.zhen.mypersonalshop.Model.Role;
import com.zhen.mypersonalshop.Model.User;
import com.zhen.mypersonalshop.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        Role newRole = new Role();
        if(role.getId() != 0)
        {
            newRole = roleRepository.findById(role.getId()).get();
        }
        newRole.setName(role.getName().toLowerCase());
        return roleRepository.save(newRole);

    }

    @Override
    public Role getRole(long id) {

        Optional<Role> role = roleRepository.findById(id);
        if(!role.isPresent())
        {
            throw new ResourceNotFoundException("role id " + id + " not found!");
        }
        return role.get();
    }

    @Override
    public Role getRoleByName(String name) {
        Optional<Role> role = roleRepository.findRoleByName(name);
        if(role != null)
        {
            return role.get();
        }
        else
        {
            throw new ResourceNotFoundException("role name " + name + " not found!");
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }

    @Override
    public void deleteRole() {

    }
}
