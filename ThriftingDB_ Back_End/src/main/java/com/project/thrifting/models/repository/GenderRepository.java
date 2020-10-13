
package com.project.thrifting.models.repository;

import com.project.thrifting.models.Genders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Genders, Integer>{
    
}
