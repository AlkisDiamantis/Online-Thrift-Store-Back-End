
package com.project.thrifting.service;


import com.project.thrifting.models.ERole;
import com.project.thrifting.models.Role;
import com.project.thrifting.models.repository.RoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleServiceInterface {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }

}
