package com.zhen.mypersonalshop.Controller;

import com.zhen.mypersonalshop.Model.Role;
import com.zhen.mypersonalshop.Service.RoleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/roles")
    public ResponseEntity<?> createRole(@Valid @RequestBody Role role)
    {
        Role newRole = roleService.addRole(role);
        return new ResponseEntity<>(newRole, HttpStatus.OK);
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<?> getAllRoles()
    {
        List<Role> roleList = roleService.getAllRoles();
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

    @GetMapping(value = "roles/{roleId}")
    public ResponseEntity<?> getRole(@PathVariable long roleId)
    {
        Role role = roleService.getRole(roleId);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PutMapping(value = "role/{roleId}")
    public ResponseEntity<?> updateRole(@PathVariable long roleId, @Valid @RequestBody Role role)
    {
        Role activeRole = roleService.updateRole(role, roleId);
        return new ResponseEntity<>(activeRole, HttpStatus.OK);
    }

    @DeleteMapping(value = "role/{roleId}")
    public void deleteRole(@PathVariable long roleId)
    {
        roleService.deleteRole(roleId);
    }




}
