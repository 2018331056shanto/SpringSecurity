package com.SpringSecurity.SpringSecurity.Controller;

import com.SpringSecurity.SpringSecurity.Entity.User;
import com.SpringSecurity.SpringSecurity.Service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return loginService.getUsers();
    }
    @PostMapping("/Login")
    public String login(@RequestBody User user){
//        System.out.println("hello user");
        return  loginService.verify(user);
    }
}
