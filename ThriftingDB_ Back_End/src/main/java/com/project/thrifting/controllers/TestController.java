package com.project.thrifting.models.controllers;

import com.project.thrifting.models.User;
import com.project.thrifting.service.UserServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> adminAccess() {

        return userServiceInterface.getAllUsers();
    }

    @GetMapping("/deleteUser/{userid}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deletesale(@PathVariable Long userid) {
        
        
        userServiceInterface.deleteUser(userid);

    }

}
