package com.project.thrifting.service;

import com.project.thrifting.models.Conditions;
import com.project.thrifting.models.repository.ConditionsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionsServiceImplimentation implements ConditionsServiceInterface {

    @Autowired
    ConditionsRepository conditionsRepository;

    @Override
    public List<Conditions> findAllConditions() {
        return conditionsRepository.findAll();
    }

    @Override
    public Conditions findbyid(int id) {
        return conditionsRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }

}
