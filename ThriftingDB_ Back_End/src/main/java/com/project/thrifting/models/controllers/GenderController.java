
package com.project.thrifting.models.controllers;
import com.project.thrifting.models.Genders;
import com.project.thrifting.service.GenderServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/welcome")
public class GenderController {

    @Autowired
    GenderServiceInterface genderServiceInterface;

    @GetMapping("/gender")
    public List<Genders> getCategories() {

        return genderServiceInterface.findAllGenders();
    }
}
