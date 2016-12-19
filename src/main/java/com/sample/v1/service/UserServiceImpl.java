package com.sample.v1.service;

import com.sample.core.dao.BloodRequestDao;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.BloodRequest;
import com.sample.core.domain.User;
import com.sample.response.Response;
import com.sample.v1.request.BloodRequestRequest;
import com.sample.v1.request.UpdateUserRequest;
import com.sample.v1.response.BloodRequestResponse;
import com.sample.v1.response.UpdateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BloodRequestDao bloodRequestDao;

    public Response update(UpdateUserRequest updateUserRequest) {
        User user = userDao.get(updateUserRequest.getUserId());
        user.setName(updateUserRequest.getName());
        user.setBloodGroup(updateUserRequest.getBloodGroup());
        user = userDao.save(user);
        return new UpdateUserResponse.UpdateUserResponseBuilder()
                .setName(user.getName())
                .setPhone(user.getPhone())
                .setBloodGroup(user.getBloodGroup())
                .build();
    }

    public Response bloodRequest(BloodRequestRequest bloodRequestRequest) {
        User user = userDao.get(bloodRequestRequest.getUserId());
        BloodRequest bloodRequest = new BloodRequest();
        bloodRequest.setDescription(bloodRequestRequest.getDescription());
        bloodRequest.setPhoneNumber(bloodRequestRequest.getPhoneNumber());
        bloodRequest.setAddress(bloodRequestRequest.getAddress());
        bloodRequest.setBloodGroup(bloodRequestRequest.getBloodGroup());
        bloodRequest.setRequestedBy(user);
        bloodRequestDao.save(bloodRequest);
        return new BloodRequestResponse.BloodRequestResponseBuilder()
                .setName(user.getName())
                .setPhone(user.getPhone())
                .setBloodGroup(user.getBloodGroup())
                .build();
    }
}
