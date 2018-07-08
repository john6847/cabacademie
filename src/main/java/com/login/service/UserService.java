package com.login.service;

import com.login.model.LocalUser;
import com.login.model.LocalUser;
import com.login.model.Role;
import com.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(7);
    }


    public List<LocalUser> fetchAllUsers(){
        return userRepository.findAll();
    }

    public LocalUser fetchUser(Long id){
        return userRepository.findOne(id);
    }

    public LocalUser updateUser(LocalUser localUser){
        LocalUser currentLocalUser = userRepository.findOne(localUser.getId());
        currentLocalUser.setCountry(localUser.getCountry());
        currentLocalUser.setEmail(localUser.getEmail());
        currentLocalUser.setFirstName(localUser.getFirstName());
        currentLocalUser.setImage(localUser.getImage());
        currentLocalUser.setLastName(localUser.getLastName());
        currentLocalUser.setPassword(localUser.getPassword());
        currentLocalUser.setPasswordConfirm(localUser.getPasswordConfirm());
        currentLocalUser.setProvider(localUser.getProvider());
        currentLocalUser.setTitle(localUser.getTitle());

        return userRepository.save(currentLocalUser);
    }
    public LocalUser saveLocalUser(LocalUser user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.delete(id);
    }
    //other delete methods
    //other fetching methods



    @Transactional
    public void crearAdmin(){
        LocalUser currentUser =  userRepository.findByUsername("admin");

        if(currentUser==null){
            System.out.println("There+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            LocalUser user=  new LocalUser();
            user.setFirstName("Cab");
            user.setLastName("Acdemie");
            user.setUsername("admin");
            user.setPassword(passwordEncoder().encode("admin1234"));
            saveLocalUser(user);
            Set<Role> roles = new HashSet<>();
            Role role1 = new Role();
            Role role2 = new Role();
            role1.setRole("ADMIN");
            role2.setRole("USER");
            role1=roleService.saveRole(role1);
            role2=roleService.saveRole(role2);

            roles.add(role1);
            roles.add(role2);
            user.setRoles(roles);
            saveLocalUser(user);

        }
    }


}
