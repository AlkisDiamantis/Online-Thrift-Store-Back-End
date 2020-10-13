
package com.project.thrifting.models.repository;

import com.project.thrifting.models.Conditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionsRepository extends JpaRepository<Conditions, Integer>{
    
}
