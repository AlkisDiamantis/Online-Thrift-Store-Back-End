
package com.project.thrifting.controllers;

import com.project.thrifting.models.Conditions;
import com.project.thrifting.service.ConditionsServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/welcome")
public class ConditionController {
    
    @Autowired 
    ConditionsServiceInterface conditionsServiceInterface;

    @GetMapping("/conditions")
    public List<Conditions> getConditions() {
        
        
        return conditionsServiceInterface.findAllConditions();
    }
}
