package com.example.TestProject.service.security;

public interface ISecurityService {
    String findLoggedInUsername();

    void autoLogin(String name, String password);
}
