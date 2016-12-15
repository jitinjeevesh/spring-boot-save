package com.sample.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.core.domain.AuthenticationToken;

public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Long> {
}
