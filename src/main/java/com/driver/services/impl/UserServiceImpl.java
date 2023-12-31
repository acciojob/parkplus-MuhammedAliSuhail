package com.driver.services.impl;

import com.driver.model.User;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository4;
    @Override
    public void deleteUser(Integer userId) {
       userRepository4.deleteById(userId);
    }

    @Override
    public User updatePassword(Integer userId, String password) throws Exception {
        Optional<User> user=userRepository4.findById(userId);

        if(!user.isPresent()){
            throw new Exception("user not found");
        }else{
            User user1=user.get();
            user1.setPassword(password);
            userRepository4.save(user1);
            return user1;
        }

    }

    @Override
    public void register(String name, String phoneNumber, String password) {
            User user=new User(name,phoneNumber,password);
            userRepository4.save(user);
    }
    public void testUser(){

    }
}
