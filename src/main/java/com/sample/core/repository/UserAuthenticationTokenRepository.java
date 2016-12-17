package com.sample.core.repository;

import com.sample.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.core.domain.UserAuthenticationToken;

import java.util.List;

public interface UserAuthenticationTokenRepository extends JpaRepository<UserAuthenticationToken, Long> {

    UserAuthenticationToken findByToken(String token);

    List<UserAuthenticationToken> findAllByToken(String token);

    List<UserAuthenticationToken> findAllByUser(User user);
}
