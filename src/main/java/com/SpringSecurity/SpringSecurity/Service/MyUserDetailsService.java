package com.SpringSecurity.SpringSecurity.Service;

import com.SpringSecurity.SpringSecurity.Entity.User;
import com.SpringSecurity.SpringSecurity.Entity.UserPrinciple;
import com.SpringSecurity.SpringSecurity.Repository.LoginRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final LoginRepo loginRepo;

    public MyUserDetailsService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=loginRepo.findByEmail(username);
        if(user==null)
        {
            throw  new UsernameNotFoundException("user not found");
        }
        return new UserPrinciple(user);
    }
}
