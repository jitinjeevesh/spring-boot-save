package com.sample.v1.controller;

import com.sample.generator.ResponseGenerator;
import com.sample.response.ResponseDTO;
import com.sample.v1.service.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class RequestController extends ResponseGenerator {

    @Autowired
    private RequestServiceImpl requestService;

    @RequestMapping(value = "requests", method = RequestMethod.GET)
    public ResponseDTO list(@RequestHeader(name = "user_id", required = true) String userId) {
        return response(() -> requestService.list(Long.valueOf(userId)));
    }
}
