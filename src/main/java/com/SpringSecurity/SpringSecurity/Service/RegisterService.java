package com.SpringSecurity.SpringSecurity.Service;

import com.SpringSecurity.SpringSecurity.Entity.User;
import com.SpringSecurity.SpringSecurity.Repository.RegisterRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private  final RegisterRepo registerRepo;

    public RegisterService(RegisterRepo registerRepo) {
        this.registerRepo = registerRepo;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(10);
    public User saveUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        registerRepo.save(user);
        return  user;
    }
}
