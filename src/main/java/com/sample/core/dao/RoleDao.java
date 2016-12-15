package com.sample.core.dao;

import com.sample.core.domain.Role;
import com.sample.core.repository.RoleRepository;
import com.sample.core.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleDao implements Dao {

    @Autowired
    private RoleRepository roleRepository;

    public Role getUserRole() {
        return findByRole(Roles.ROLE_USER.getName());
    }

    public Role findByRole(String role) {
        return roleRepository.findByUserRole(role);
    }

}
