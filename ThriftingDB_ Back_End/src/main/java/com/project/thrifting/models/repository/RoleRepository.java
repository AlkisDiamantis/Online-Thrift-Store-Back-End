
package com.project.thrifting.models.repository;

import com.project.thrifting.models.ERole;
import com.project.thrifting.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer>{
    
     Optional<Role> findByName(ERole name);
    
}
