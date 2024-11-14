package com.SpringSecurity.SpringSecurity.Repository;

import com.SpringSecurity.SpringSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepo extends JpaRepository<User,Integer> {

    User findByEmail(String username);

}
