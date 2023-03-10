package com.medicare.controller;

import com.medicare.config.JwtUtils;
import com.medicare.entity.JwtRequest;
import com.medicare.entity.JwtResponse;
import com.medicare.entity.User;
import com.medicare.service.imp.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
   @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch(UsernameNotFoundException e){
            e.printStackTrace();


        }
        UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Autowired
    private AuthenticationManager authenticationManager;
    private void authenticate(String username,String password){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
