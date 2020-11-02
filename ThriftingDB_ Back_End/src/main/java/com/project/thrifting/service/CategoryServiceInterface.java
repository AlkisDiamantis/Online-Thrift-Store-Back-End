
package com.project.thrifting.service;

import com.project.thrifting.models.Categories;
import java.util.List;

public interface CategoryServiceInterface {
    
    
    public List<Categories> findAllCategories();
    
    
    public Categories findCategorybyid(int id);
}
