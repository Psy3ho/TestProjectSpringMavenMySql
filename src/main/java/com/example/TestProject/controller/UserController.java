package com.example.TestProject.controller;

import com.example.TestProject.model.User;
import com.example.TestProject.service.security.SecurityService;
import com.example.TestProject.service.user.UserService;
import com.example.TestProject.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping(path = "/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    /*@GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }*/
    @PostMapping(value = "/registration")
    public String registration(@RequestBody User userForm, BindingResult bindingResult) {


        System.out.println(userForm.getPassword() + "heslo");
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        //userService.addUser(userForm.getUserName(),userForm.getEmail(),userForm.getPasswordConfirm());


        securityService.autoLogin(userForm.getUserName(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @PostMapping(value = "/login")
    public String Login(Model model, String error, String logout) {
        if(error != null) model.addAttribute("error","Your username and password is invalid");

        if(logout != null) model.addAttribute("message","You have been logged out succesfully");

        return "login";
    }

    @GetMapping({"/","/welcome"})
    public String velcome(Model model) {
        return "welcome";
    }


//    @PostMapping(value = "/addUser")
//    public ResponseEntity<String> addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
//        userBusinessLogic.addUser(name, email, password);
//        return new ResponseEntity<>("New user " + name +" successfully added", HttpStatus.OK);
//    }

    @GetMapping(value = "/allUsers")
    public  ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

//    @PutMapping(value = "/updateUser")
//    public ResponseEntity<String> updateUser(@RequestParam Integer id,@RequestParam String name, @RequestParam String email, @RequestParam String password) {
//        userBusinessLogic.updateUser(id, name, email, password);
//        return new ResponseEntity<>("User with id " + id +" updated successfully", HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/userById")
//    public ResponseEntity<String> getUserById(@RequestParam Integer id) {
//        return new ResponseEntity<>(String.valueOf(userBusinessLogic.findUserById(id)),HttpStatus.OK);
//    }
}
