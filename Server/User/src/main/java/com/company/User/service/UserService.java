package com.company.User.service;

import com.company.User.model.User;
import com.company.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user)
    {
        userRepository.save(user);
    }


}
