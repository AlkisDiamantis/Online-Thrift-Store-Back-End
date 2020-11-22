
package com.project.thrifting.controllers;

import com.project.thrifting.models.Sizes;
import com.project.thrifting.service.SizeServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/welcome")
public class SizeController {
    @Autowired
    SizeServiceInterface serviceInterface;
    
        @GetMapping("/sizes")
    public List<Sizes> getCategories() {

        return serviceInterface.findAllSizes();
    }
}
