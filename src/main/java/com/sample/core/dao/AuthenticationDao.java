package com.sample.core.dao;

import com.sample.core.domain.Authentication;
import com.sample.core.domain.User;
import com.sample.core.repository.AuthenticationRepository;
import com.sample.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AuthenticationDao implements Dao {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Authentication save(Authentication authentication) {
        return authenticationRepository.save(authentication);
    }
}
