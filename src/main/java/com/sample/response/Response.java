package com.sample.response;

import org.springframework.validation.BindingResult;

public interface Response {

    Response bindingResult(BindingResult bindingResult);

    BindingResult bindingResult();

    Response successMessage(String message);

    String successMessage();
}
