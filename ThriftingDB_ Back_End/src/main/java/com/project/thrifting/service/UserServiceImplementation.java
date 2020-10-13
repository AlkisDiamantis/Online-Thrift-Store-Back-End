
package com.project.thrifting.service;

import com.project.thrifting.models.User;
import com.project.thrifting.models.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public void insertUser(User u) {
        userRepository.save(u);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findbyid(Long id) {
      return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

    @Override
    public List<User> getAllUsers() {
      return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userid) {
       userRepository.deleteById(userid);
    }

}
