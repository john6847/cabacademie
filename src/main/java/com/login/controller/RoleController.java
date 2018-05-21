package com.login.controller;

import com.login.model.Role;
import com.login.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dany on 20/05/2018.
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Role role= roleService.fetchRole(id);
        if(role==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles= roleService.fetchAllRole();
        if(roles.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<Role> saveRole(@Valid @RequestBody Role role){
        Role currentRole= roleService.saveRole(role);
        if(currentRole==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(roleService.fetchRole(id)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Role currentRole= roleService.updateRole(role);
        if (currentRole==null)
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

        return new ResponseEntity<>(currentRole, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id ){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(roleService.fetchRole(id)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        roleService.deleteRole(id);
        return new ResponseEntity<>("Role with "+ id+" Deleted!", HttpStatus.OK);
    }
}
