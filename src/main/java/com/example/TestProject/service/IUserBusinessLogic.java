package com.example.TestProject.service;

import com.example.TestProject.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserBusinessLogic {

    void addUser(String name, String email, String password);

    void updateUser(Integer id, String name, String email, String password);

    Optional<User> findUserById(Integer id);

    Optional<User> deleteUserById(Integer id);

    List<User> getAllUsers();

    void deleteAllUsers();

}
