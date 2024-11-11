package com.user.servies.UserService.com.user.servies.repository;

import com.user.servies.UserService.com.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositor extends JpaRepository<User,String > {
}
