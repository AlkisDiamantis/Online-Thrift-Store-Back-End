
package com.project.thrifting.service;

import com.project.thrifting.models.Sizes;
import java.util.List;

public interface SizeServiceInterface {
    
    public List<Sizes> findAllSizes();
    
    
    public Sizes getSizebyId(int id );
}
