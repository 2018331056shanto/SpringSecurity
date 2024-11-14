package com.SpringSecurity.SpringSecurity.Repository;

import com.SpringSecurity.SpringSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<User,Integer> {

}
