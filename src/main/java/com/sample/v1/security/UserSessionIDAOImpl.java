package com.sample.v1.security;

import com.oauth.dao.AuthenticationTokenDAO;
import com.oauth.service.RESTSpringSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionIDAOImpl implements AuthenticationTokenDAO {

    private final static Logger logger = LoggerFactory.getLogger(UserSessionIDAOImpl.class);

    @Autowired
    private RESTSpringSecurityService restSpringSecurityService;

    @SuppressWarnings("unchecked")
    @Override
    public com.oauth.data.AuthenticationToken find(String token) {
        return null;
    }

    @Override
    public void save(String username, com.oauth.data.AuthenticationToken authenticationToken) {
    }
}
