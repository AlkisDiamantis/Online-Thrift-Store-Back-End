
package com.project.thrifting.models.repository;

import com.project.thrifting.models.Categories;
import com.project.thrifting.models.Genders;
import com.project.thrifting.models.Sale;
import com.project.thrifting.models.Sizes;
import com.project.thrifting.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer>{
    
   public Optional<List<Sale>> findByGenderid(Genders gender);
   
     public Optional<List<Sale>> findByCategoryid(Categories category);
     
      public Optional<List<Sale>> findBySizeid(Sizes size);
      
      public Optional<List<Sale>> findByUserid (User user);
      
      public Optional<List<Sale>> findByPriceLessThan(Double price);
    
}
