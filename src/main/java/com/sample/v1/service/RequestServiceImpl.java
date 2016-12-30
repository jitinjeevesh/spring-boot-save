package com.sample.v1.service;

import com.sample.core.dao.BloodRequestDao;
import com.sample.core.dao.UserDao;
import com.sample.core.domain.BloodRequest;
import com.sample.core.domain.User;
import com.sample.response.Response;
import com.sample.service.AbstractService;
import com.sample.v1.request.BloodRequestRequest;
import com.sample.v1.request.UpdateUserRequest;
import com.sample.v1.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl extends AbstractService implements RequestService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BloodRequestDao bloodRequestDao;

    public Response list(Long userId) {
        List<BloodRequest> bloodRequestList = bloodRequestDao.list();
        BloodRequestListResponse.BloodRequestListResponseBuilder bloodRequestListResponseBuilder = new BloodRequestListResponse.BloodRequestListResponseBuilder();
        bloodRequestList.stream().forEach(bloodRequest -> {
            bloodRequestListResponseBuilder.setBloodRequestDetailResponseList((BloodRequestDetailResponse) new BloodRequestDetailResponse.BloodRequestDetailResponseBuilder()
                    .setName(bloodRequest.getRequestedBy().getName())
                    .setPhone(bloodRequest.getPhoneNumber())
                    .setBloodGroup(bloodRequest.getBloodGroup())
                    .setDescription(bloodRequest.getDescription())
                    .setAddress(bloodRequest.getAddress()).build());
        });
        return bloodRequestListResponseBuilder.build();
    }

    public Response detail(Long id, Long userId) {
        isNullObjectWithException(id, "null.user.id.error.message");
        User user = userDao.get(id);
        isNullObjectWithException(user, "null.user.error.message");
        User loginUser = userDao.get(userId);
        return new UserDetailResponse.UserDetailResponseBuilder()
                .setName(user.getName())
                .setPhone(user.getPhone())
                .setBloodGroup(user.getBloodGroup())
                .build();
    }
}
