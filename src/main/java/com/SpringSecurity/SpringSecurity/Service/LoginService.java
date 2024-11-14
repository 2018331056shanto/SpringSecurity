package com.SpringSecurity.SpringSecurity.Service;

import com.SpringSecurity.SpringSecurity.Entity.User;
import com.SpringSecurity.SpringSecurity.Repository.LoginRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final LoginRepo loginRepo;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public LoginService(LoginRepo loginRepo, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.loginRepo = loginRepo;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String verify(User user) {

        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

        if(authentication.isAuthenticated())
        {
            return  jwtService.generateToken(user.getEmail());

        }
        else {
            return "fail";
        }
    }

    public List<User> getUsers() {

        return loginRepo.findAll();
    }
}
