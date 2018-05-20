package com.login.service;

import com.login.model.LocalUser;
import com.login.model.LocalUser;
import com.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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

    public void deleteUser(Long id){
        userRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
