package com.sample.v1.controller;

import com.sample.generator.ResponseGenerator;
import com.sample.response.ResponseDTO;
import com.sample.v1.request.UpdateUserRequest;
import com.sample.v1.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends ResponseGenerator {

    @Autowired
    private AuthServiceImpl authServiceImpl;

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDTO update(@Validated @RequestBody final UpdateUserRequest loginCO, BindingResult bindingResult) {
        return response(() -> authServiceImpl.login(loginCO).bindingResult(bindingResult));
    }

    @RequestMapping(value = "/demo", method = RequestMethod.PUT)
    public void demo(@RequestHeader(name = "userId", required = false) String userId) {
        System.out.println("..........................................");
        System.out.println(userId);
    }
}
