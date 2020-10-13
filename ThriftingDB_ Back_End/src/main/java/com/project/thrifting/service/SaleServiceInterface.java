
package com.project.thrifting.service;

import com.project.thrifting.models.Categories;
import com.project.thrifting.models.Genders;
import com.project.thrifting.models.Sale;
import com.project.thrifting.models.Sizes;
import com.project.thrifting.models.User;
import java.util.List;

public interface SaleServiceInterface {
      
    
    public void saveSale(Sale sale);
    
    public List<Sale> getallsales();
    
    public List<Sale> getSalesByGenderid(Genders gender);
    
      public List<Sale> getSalesByCategoryid(Categories category);
      
      public List<Sale> getSalesBySizeid(Sizes size);
      
      public List<Sale> getSaleByUserId(User user);
      
      public void deleteSale(int saleid);
      
      public List <Sale> getSaleByPrice(Double price);
}
