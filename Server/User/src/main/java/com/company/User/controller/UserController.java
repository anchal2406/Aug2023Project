package com.company.User.controller;

import com.company.User.model.User;
import com.company.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method= RequestMethod.POST, value ="/users")
    public User addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return user;
    }
}
