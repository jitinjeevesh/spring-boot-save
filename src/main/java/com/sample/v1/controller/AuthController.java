package com.sample.v1.controller;

import com.sample.generator.ResponseGenerator;
import com.sample.response.ResponseDTO;
import com.sample.v1.request.LoginRequest;
import com.sample.v1.request.LogoutRequest;
import com.sample.v1.request.RegistrationRequest;
import com.sample.v1.request.ValidateMobileRequest;
import com.sample.v1.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends ResponseGenerator {

    @Autowired
    private AuthServiceImpl authServiceImpl;

    @RequestMapping(value = "/validateMobile", method = RequestMethod.POST)
    public ResponseDTO validateMobile(@Validated @RequestBody final ValidateMobileRequest validateMobileRequest, BindingResult bindingResult) {
        return response(() -> authServiceImpl.validateMobile(validateMobileRequest).bindingResult(bindingResult));
    }

    @RequestMapping("/login")
    public ResponseDTO login(@Validated @RequestBody final LoginRequest loginCO, BindingResult bindingResult) {
        return response(() -> authServiceImpl.login(loginCO).bindingResult(bindingResult));
    }

    @RequestMapping("/register")
    public ResponseDTO register(@Validated @RequestBody RegistrationRequest registrationCO, BindingResult bindingResult) {
        return response(() -> authServiceImpl.register(registrationCO).bindingResult(bindingResult));
    }

    @RequestMapping("/logout")
    public void logout(@Validated @RequestBody LogoutRequest logoutCO, BindingResult bindingResult) {
        authServiceImpl.logout(logoutCO);
    }
}
