package com.sample.v1.service;

import com.sample.core.dao.RoleDao;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.User;
import com.sample.response.Response;
import com.sample.v1.request.LoginRequest;
import com.sample.v1.request.LogoutRequest;
import com.sample.v1.request.RegistrationRequest;
import com.sample.v1.request.ValidateMobileRequest;
import com.sample.v1.response.LoginResponse;
import com.sample.v1.response.ValidateMobileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public Response validateMobile(ValidateMobileRequest validateMobileRequest) {
        Long isMobileNumberRegistered = userDao.countByPhone(validateMobileRequest.getMobileNumber());
        ValidateMobileResponse validateMobileResponse = new ValidateMobileResponse();
        validateMobileResponse.setValidate(isMobileNumberRegistered > 0);
        System.out.println(".................");
        System.out.println(isMobileNumberRegistered);
        return validateMobileResponse;
    }

    public Response register(RegistrationRequest registrationCO) {
        User user = new User();
        user.setName(registrationCO.getName());
        user.setPhone(registrationCO.getMobileNumber());
        user.setRole(roleDao.getUserRole());
        user = userDao.save(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(user.getId());
        loginResponse.setName(user.getName());
        loginResponse.setPhone(user.getPhone());
        return loginResponse;
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
    }

}
