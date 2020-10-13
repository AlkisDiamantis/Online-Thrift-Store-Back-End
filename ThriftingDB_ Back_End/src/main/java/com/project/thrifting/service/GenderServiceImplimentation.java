
package com.project.thrifting.service;

import com.project.thrifting.models.Genders;
import com.project.thrifting.models.repository.GenderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImplimentation implements GenderServiceInterface{
    
    @Autowired
    GenderRepository genderRepository;
    

    @Override
    public List<Genders> findAllGenders() {
       return genderRepository.findAll();
    }

    @Override
    public Genders findGenderbyId(int id) {
       return genderRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: gender is not found."));
    }
    
}
