package com.company.User.controller;

import com.company.User.model.User;
import com.company.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Optional<User> validateUser(@RequestBody User user) {
        Optional<User> loggedInUser = userRepository.findById(user.getEmail());
        if(loggedInUser.isPresent()) {
            if(user.getPassword().equals(loggedInUser.get().getPassword())){
                return loggedInUser;}
            else{
                return Optional.empty();
            }
        }
        else{
            return Optional.empty();
        }
    }

}
