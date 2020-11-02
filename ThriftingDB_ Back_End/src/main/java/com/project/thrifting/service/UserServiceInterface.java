
package com.project.thrifting.service;

import com.project.thrifting.models.User;
import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    public void insertUser(User u);

    public Optional<User> findByUsername(String username);
    
    public User findbyid(Long id);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);
    
    public List<User> getAllUsers();
    
    public void deleteUser(Long userid);

}
