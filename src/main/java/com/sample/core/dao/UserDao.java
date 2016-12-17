package com.sample.core.dao;

import com.sample.core.domain.User;
import com.sample.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDao implements Dao {

    @Autowired
    private UserRepository userRepository;

    public User get(Long id) {
        return userRepository.findOne(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByMobileNumber(String phoneNumber) {
        return userRepository.findByPhone(phoneNumber);
    }

    public Long countByPhone(String phoneNumber) {
        return userRepository.countByPhone(phoneNumber);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
