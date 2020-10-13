
package com.project.thrifting.service;

import com.project.thrifting.models.Genders;
import java.util.List;

public interface GenderServiceInterface {
    
    public List<Genders> findAllGenders();
    
    
    public Genders findGenderbyId(int id );
}
