package com.example.securecoding.service;

import com.example.securecoding.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<Long,User> database = new HashMap<>();

    public Collection<User> getAllUsers(){

        return database.values();

    }

    public User addUser(User user){

        if(database.size()>10){

            throw new RuntimeException("Resource limit exceeded");

        }

        user.setId((long)(database.size()+1));

        database.put(user.getId(),user);

        return user;
    }

}
