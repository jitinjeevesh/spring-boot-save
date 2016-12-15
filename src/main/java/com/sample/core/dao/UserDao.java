package com.sample.core.dao;

import com.sample.core.domain.User;
import com.sample.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao implements Dao {

    @Autowired
    private UserRepository userRepository;

    public User get(Long id) {
        return userRepository.findOne(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
