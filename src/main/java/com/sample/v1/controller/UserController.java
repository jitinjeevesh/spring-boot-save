package com.sample.v1.controller;

import com.sample.generator.ResponseGenerator;
import com.sample.response.ResponseDTO;
import com.sample.v1.request.UpdateUserRequest;
import com.sample.v1.service.AuthServiceImpl;
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
}
