package com.example.SpringbootWEBAPI.services;

import com.example.SpringbootWEBAPI.Models.Users;
import com.example.SpringbootWEBAPI.Repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class userService {

    @Autowired
    private UsersRepo service;

    public String getUserId(String email,String pass){
        Users user = service.getUserByCredentials(email.toLowerCase(),pass);
        return user == null ? null : user.getId().toString();
    }

    public Users getUserById(String id){
        return service.getById(UUID.fromString(id));
    }
}
