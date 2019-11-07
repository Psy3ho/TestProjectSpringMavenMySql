package com.example.TestProject.service.user;

import com.example.TestProject.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void addUser(String name, String email, String password);

    void updateUser(Integer id, String name, String email, String password);

    Optional<User> findUserById(Integer id);

    Optional<User> deleteUserById(Integer id);

    List<User> getAllUsers();

    User findByUsername(String userName);

    void save(User user);

    void deleteAllUsers();

}
