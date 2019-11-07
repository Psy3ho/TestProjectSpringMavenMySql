package com.example.TestProject.service.user;

import com.example.TestProject.model.User;
import com.example.TestProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(String name, String email, String password) {
        User user = new User();

        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id, String name, String email, String password) {
        Optional<User> updated = findUserById(id);
        if(updated.isPresent()) {
            User present  = updated.get();
            if(name != null) {
                present.setUserName(name);
            }
            if(email != null) {
                present.setEmail(email);
            }
            if(password != null) {
                present.setPassword(password);
            }

        }

    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> deleteUserById(Integer id) {
        Optional<User> deleted = findUserById(id);
        deleted.ifPresent(user -> userRepository.delete(user));
        return deleted;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String userName) {
       return userRepository.findByUserName(userName);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
