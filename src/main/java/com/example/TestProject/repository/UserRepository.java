package com.example.TestProject.repository;

import com.example.TestProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Integer> {
}
