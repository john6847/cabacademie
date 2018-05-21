package com.login.service;

import com.login.model.Role;
import com.login.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> fetchAllRole(){
        return roleRepository.findAll();
    }

    public Role fetchRole(Long id){
        return roleRepository.findOne(id);
    }

    public Role updateRole(Role role){
        Role currentRole= roleRepository.findOne(role.getId());
        currentRole.setRole(role.getRole());

        return roleRepository.save(currentRole);
    }
    public Role saveRole(Role role){
        return roleRepository.save(role);
    }
    public void deleteRole(Long id){
        roleRepository.delete(id);
    }
    //other delete methods
    //other fetching methods

}
