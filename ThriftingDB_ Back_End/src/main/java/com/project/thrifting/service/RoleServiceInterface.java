
package com.project.thrifting.service;


import com.project.thrifting.models.ERole;
import com.project.thrifting.models.Role;
import java.util.Optional;

public interface RoleServiceInterface {
    
    
      Optional<Role> findByName(ERole name);
}
