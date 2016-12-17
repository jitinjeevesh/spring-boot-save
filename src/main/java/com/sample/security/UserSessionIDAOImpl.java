package com.sample.security;

import com.oauth.dao.AuthenticationTokenDAO;
import com.oauth.data.AuthenticationToken;
import com.oauth.service.RESTSpringSecurityService;
import com.sample.core.dao.UserAuthenticationTokenDao;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.User;
import com.sample.core.domain.UserAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionIDAOImpl implements AuthenticationTokenDAO {

    private final static Logger logger = LoggerFactory.getLogger(UserSessionIDAOImpl.class);

    @Autowired
    private RESTSpringSecurityService restSpringSecurityService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserAuthenticationTokenDao userAuthenticationTokenDao;

    @SuppressWarnings("unchecked")
    @Override
    public AuthenticationToken find(String token) {
        UserAuthenticationToken userAuthenticationToken = userAuthenticationTokenDao.findByToken(token);
        if (userAuthenticationToken != null) {
            User user = userAuthenticationToken.getUser();
            return new AuthenticationToken(userAuthenticationToken.getId(), userAuthenticationToken.getToken(), userAuthenticationToken.getExpiryDateTime(), user.getPhone());
        }
        return null;
    }

    @Override
    public void save(String username, AuthenticationToken authenticationToken) {
        User user = userDao.findByMobileNumber(username);
        if (user != null) {
            UserAuthenticationToken token = new UserAuthenticationToken();
            token.setUser(user);
            token.setExpiryDateTime(authenticationToken.getExpiryDateTime());
            token.setToken(authenticationToken.getToken());
            userAuthenticationTokenDao.save(token);
        }
    }
}
