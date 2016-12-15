package com.sample.v1.controller;

import com.sample.generator.ResponseGenerator;
import com.sample.response.ResponseDTO;
import com.sample.v1.request.LoginRequest;
import com.sample.v1.request.LogoutRequest;
import com.sample.v1.request.RegistrationRequest;
import com.sample.v1.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends ResponseGenerator {

    @Autowired
    private AuthService authService;

    @RequestMapping("/login")
    public ResponseDTO login(@Validated @RequestBody final LoginRequest loginCO, BindingResult bindingResult) {
        return response(() -> authService.login(loginCO).bindingResult(bindingResult));
    }

    @RequestMapping("/register")
    public void register(@Validated @RequestBody RegistrationRequest registrationCO, BindingResult bindingResult) {
        authService.register(registrationCO);
    }

    @RequestMapping("/logout")
    public void logout(@Validated @RequestBody LogoutRequest logoutCO, BindingResult bindingResult) {
        authService.logout(logoutCO);
    }
}
