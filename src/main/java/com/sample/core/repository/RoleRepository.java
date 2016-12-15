package com.sample.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.core.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByUserRole(String userRole);
}
