
package com.project.thrifting.models.repository;

import com.project.thrifting.models.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizesRepository  extends JpaRepository<Sizes, Integer>{
    
}
