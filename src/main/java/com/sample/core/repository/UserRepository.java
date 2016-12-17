package com.sample.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.core.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByPhone(String phone);

    Long countByPhone(String phone);
}
