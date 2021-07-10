package com.example.SpringbootWEBAPI.Controllers;

import com.example.SpringbootWEBAPI.Helpers.MD5;
import com.example.SpringbootWEBAPI.JWT.JwtTokenUtil;
import com.example.SpringbootWEBAPI.Models.JwtRequest;
import com.example.SpringbootWEBAPI.Models.JwtResponse;
import com.example.SpringbootWEBAPI.Models.JwtUserDetailsService;
import com.example.SpringbootWEBAPI.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@CrossOrigin
@RequestMapping("/authenticate")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private userService us;




    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {


        UserDetails userDetails = null;

        String id = us.getUserId(authenticationRequest.getEmail(), MD5.getMd5(authenticationRequest.getPassword()));

        if(id == null){
            return ResponseEntity.status(401).body("unauthorized");
        }
        else{
            userDetails = userDetailsService
                    .loadUserById(id);
            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));
        }
    }



}
