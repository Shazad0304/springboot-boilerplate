package com.example.SpringbootWEBAPI.Models;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JwtUserDetailsService {
    private String userName;
    private String password;



    public UserDetails loadUserById(String a){
        String[] ab = {"manager"};
        User.UserBuilder builder = User.withUsername(a);
        builder.password(new BCryptPasswordEncoder().encode("password"));
        builder.roles(ab);
        return builder.build();
    }
}
