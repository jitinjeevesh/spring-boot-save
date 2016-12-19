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
import com.sample.v1.request.LogoutRequest;
import com.sample.v1.request.RegistrationRequest;
import com.sample.v1.request.UpdateUserRequest;
import com.sample.v1.response.LoginResponse;
import com.sample.v1.response.RegistrationResponse;
import com.sample.v1.response.UpdateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Response update(UpdateUserRequest updateUserRequest) {
        User user = userDao.get(updateUserRequest.getUserId());
        user.setName(updateUserRequest.getName());
        user.setBloodGroup(updateUserRequest.getBloodGroup());
        user = userDao.save(user);
        Response response = new UpdateUserResponse.UpdateUserResponseBuilder()
                .setName(user.getName())
                .setPhone(user.getPhone())
                .setBloodGroup(user.getBloodGroup())
                .build();
        return response;
    }
}
