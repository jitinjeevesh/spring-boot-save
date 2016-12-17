package com.sample.v1.service;

import com.oauth.service.RESTSecurityUserDetails;
import com.oauth.service.RESTSpringSecurityService;
import com.sample.core.dao.AuthenticationDao;
import com.sample.core.dao.RoleDao;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.Authentication;
import com.sample.core.domain.DigitAuthentication;
import com.sample.core.domain.User;
import com.sample.response.Response;
import com.sample.security.UserSessionIDAOImpl;
import com.sample.v1.request.LoginRequest;
import com.sample.v1.request.LogoutRequest;
import com.sample.v1.request.RegistrationRequest;
import com.sample.v1.response.LoginResponse;
import com.sample.v1.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private AuthenticationDao authenticationDao;
    @Autowired
    private UserSessionIDAOImpl userSessionIDAO;
    @Autowired
    private RESTSpringSecurityService restSpringSecurityService;

    public Response register(RegistrationRequest registrationRequest) {
        User user = userDao.findByMobileNumber(registrationRequest.getMobileNumber());
        Boolean isValidated = user == null;
        if (user == null) {
            Authentication authentication = new DigitAuthentication.DigitAuthenticationBuilder()
                    .setSecret(registrationRequest.getdSecret())
                    .setToken(registrationRequest.getdToken())
                    .setUserId(registrationRequest.getdUserId())
                    .build();
            authentication = authenticationDao.save(authentication);
            user = new User();
            user.setPhone(registrationRequest.getMobileNumber());
            user.setAuthentication(authentication);
            user.setRole(roleDao.getUserRole());
            user = userDao.save(user);
        } else {
            user = userDao.findByMobileNumber(registrationRequest.getMobileNumber());
        }
        RESTSecurityUserDetails restSecurityUserDetails = restSpringSecurityService.authenticate(user.getPhone(), "");
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setValidate(!isValidated);
        registrationResponse.setAuthToken(restSecurityUserDetails.getAccessToken().getToken());
        return registrationResponse;
    }

    public Response login(LoginRequest loginCO) {
        User user = new User();
        user.setName(loginCO.getName());
        user.setPhone(loginCO.getMobileNumber());
        user.setRole(roleDao.getUserRole());
        user = userDao.save(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(user.getId());
        loginResponse.setName(user.getName());
        loginResponse.setPhone(user.getPhone());
        return loginResponse;
    }

    public void logout(LogoutRequest logoutCO) {
        System.out.println("........................................");
    }

}
