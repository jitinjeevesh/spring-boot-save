package com.sample.core.dao;

import com.sample.core.domain.User;
import com.sample.core.domain.UserAuthenticationToken;
import com.sample.core.repository.UserAuthenticationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAuthenticationTokenDao implements Dao {

    @Autowired
    private UserAuthenticationTokenRepository userAuthenticationTokenRepository;

    public UserAuthenticationToken save(UserAuthenticationToken userAuthenticationToken) {
        return userAuthenticationTokenRepository.save(userAuthenticationToken);
    }

    public UserAuthenticationToken findByToken(String token) {
        return userAuthenticationTokenRepository.findByToken(token);
    }

    public List<UserAuthenticationToken> findAllByUser(User user) {
        return userAuthenticationTokenRepository.findAllByUser(user);
    }

    public void delete(UserAuthenticationToken userAuthenticationToken) {
        userAuthenticationTokenRepository.delete(userAuthenticationToken);
    }

    public void deleteAll(List<UserAuthenticationToken> userAuthenticationTokens) {
        userAuthenticationTokenRepository.deleteInBatch(userAuthenticationTokens);
    }
}
