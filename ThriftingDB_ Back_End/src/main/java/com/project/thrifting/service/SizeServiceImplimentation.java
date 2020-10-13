
package com.project.thrifting.service;

import com.project.thrifting.models.Sizes;
import com.project.thrifting.models.repository.SizesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImplimentation implements SizeServiceInterface{
    @Autowired
    SizesRepository sizesRepository;

    @Override
    public List<Sizes> findAllSizes() {
       return sizesRepository.findAll();
    }

    @Override
    public Sizes getSizebyId(int id) {
       return sizesRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: size is not found."));
    }
    
    
    
}
