package com.sample.security;

import com.oauth.dao.LogoutDAO;
import com.sample.core.dao.UserAuthenticationTokenDao;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.User;
import com.sample.core.domain.UserAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogoutDAOImpl implements LogoutDAO {

    private final static Logger logger = LoggerFactory.getLogger(LogoutDAOImpl.class);

    @Autowired
    private UserAuthenticationTokenDao userAuthenticationTokenDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void session(String token) {
        UserAuthenticationToken userAuthenticationToken = userAuthenticationTokenDao.findByToken(token);
        userAuthenticationTokenDao.delete(userAuthenticationToken);
    }

    @Override
    @Transactional
    public void user(String username) {
        User user = userDao.findByMobileNumber(username);
        List<UserAuthenticationToken> userAuthenticationTokens = userAuthenticationTokenDao.findAllByUser(user);
        userAuthenticationTokenDao.deleteAll(userAuthenticationTokens);
    }
}
