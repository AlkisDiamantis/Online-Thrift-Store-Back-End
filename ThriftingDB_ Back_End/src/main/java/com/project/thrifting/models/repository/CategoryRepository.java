
package com.project.thrifting.models.repository;

import com.project.thrifting.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Categories, Integer>{

    
}
