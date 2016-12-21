package com.sample.v1.controller;

import com.sample.generator.ResponseGenerator;
import com.sample.response.ResponseDTO;
import com.sample.v1.request.BloodRequestRequest;
import com.sample.v1.request.UpdateUserRequest;
import com.sample.v1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends ResponseGenerator {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDTO update(@Validated @RequestBody final UpdateUserRequest updateUserRequest, BindingResult bindingResult, @RequestHeader(name = "user_id", required = true) String userId) {
        return response(() -> {
            updateUserRequest.setUserId(userId);
            return userService.update(updateUserRequest).bindingResult(bindingResult);
        });
    }

    @RequestMapping(value = "/requestBlood", method = RequestMethod.POST)
    public ResponseDTO requestBlood(@Validated @RequestBody final BloodRequestRequest bloodRequestRequest, BindingResult bindingResult, @RequestHeader(name = "user_id", required = true) String userId) {
        return response(() -> {
            bloodRequestRequest.setUserId(userId);
            return userService.bloodRequest(bloodRequestRequest).bindingResult(bindingResult);
        });
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseDTO detail(@PathVariable(value = "id") Long id, @RequestHeader(name = "user_id", required = true) String userId) {
        return response(() -> userService.detail(id, Long.valueOf(userId)));
    }
}
