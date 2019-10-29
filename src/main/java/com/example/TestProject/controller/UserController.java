package com.example.TestProject.controller;

import com.example.TestProject.model.User;
import com.example.TestProject.service.UserBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")

public class UserController {

    @Autowired
    private UserBusinessLogic userBusinessLogic;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseEntity<String> addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        userBusinessLogic.addUser(name, email, password);
        return new ResponseEntity<String>("New user " + name +" successfully added", HttpStatus.OK);
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public  ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userBusinessLogic.getAllUsers(),HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestParam Integer id,@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        userBusinessLogic.updateUser(id, name, email, password);
        return new ResponseEntity<String>("User with id " + id +" updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/userById", method = RequestMethod.GET)
    public ResponseEntity<String> getUserById(@RequestParam Integer id) {
        return new ResponseEntity<String>(String.valueOf(userBusinessLogic.findUserById(id)),HttpStatus.OK);
    }
}
