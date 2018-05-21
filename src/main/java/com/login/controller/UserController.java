package com.login.controller;

import com.login.model.LocalUser;
import com.login.service.UserService;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocalUser> getLocalUser(@PathVariable Long id){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        LocalUser localUser= userService.fetchUser(id);
        if(localUser==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(localUser, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<LocalUser>> getAllLocalUser(){
        List<LocalUser> localUsers= userService.fetchAllUsers();
        if(localUsers.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(localUsers, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<LocalUser> saveLocalUsers(@Valid @RequestBody LocalUser localUser){
        LocalUser currentLocalUser= userService.saveLocalUser(localUser);
        if(currentLocalUser==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LocalUser> updateLocalUser(@PathVariable Long id, @RequestBody LocalUser localUser){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(userService.fetchUser(id)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        LocalUser currentLocalUser= userService.updateUser(localUser);
        if (currentLocalUser==null)
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

        return new ResponseEntity<>(currentLocalUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteLocalUser(@PathVariable Long id ){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(userService.fetchUser(id)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        userService.deleteUser(id);
        return new ResponseEntity<>("User with "+ id+" Deleted!", HttpStatus.OK);
    }
}
