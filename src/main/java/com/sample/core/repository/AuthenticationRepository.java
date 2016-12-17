package com.sample.core.repository;

import com.sample.core.domain.Authentication;
import com.sample.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
}
