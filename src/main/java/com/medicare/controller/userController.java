package com.medicare.controller;

import com.medicare.entity.Role;
import com.medicare.entity.User;
import com.medicare.entity.UserRole;
import com.medicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class userController {
    @Autowired
    private UserService userService;
    //creating user
    @PostMapping("/")
    public User createuser(@RequestBody User user) throws Exception {
        Set<UserRole> roles=new HashSet<>();
        Role rol=new Role();
        rol.setRoleId(45L);
        rol.setRoleName("NORMAL");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(rol);
        roles.add(userRole);



        roles.add(userRole);

        return this.userService.createUser(user,roles);

    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid){
        this.userService.deleteUser(userid);

    }
}
