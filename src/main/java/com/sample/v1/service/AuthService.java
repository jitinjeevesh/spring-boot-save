package com.sample.v1.service;

import com.sample.core.dao.RoleDao;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.User;
import com.sample.response.Response;
import com.sample.v1.request.LoginRequest;
import com.sample.v1.request.LogoutRequest;
import com.sample.v1.request.RegistrationRequest;
import com.sample.v1.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public void register(RegistrationRequest registrationCO) {
    }

    public Response login(LoginRequest loginCO) {
        User user = new User();
        user.setName(loginCO.getName());
        user.setPhone(loginCO.getMobileNumber().toString());
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
