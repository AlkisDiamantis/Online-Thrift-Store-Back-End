
package com.project.thrifting.service;

import com.project.thrifting.models.Conditions;
import java.util.List;

public interface ConditionsServiceInterface {
    
    
    public List<Conditions> findAllConditions();
    
    public Conditions findbyid(int id);
}
