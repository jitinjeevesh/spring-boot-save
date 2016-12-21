package com.sample.exception.handler;

import com.sample.exception.GenericException;
import com.sample.generator.ErrorObject;
import com.sample.response.ErrorResponseDTO;
import com.sample.response.ResponseDTO;
import com.sample.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    private Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);
    static final ErrorObject OBJECT = new ErrorObject();
    @Autowired
    private MessageUtil messageUtil;

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = GenericException.class)
    public ResponseDTO handle(GenericException exc) {
        return new ErrorResponseDTO.ErrorResponseBuilder<>()
                .setData(OBJECT)
                .setMessage(messageUtil.getMessage(messageUtil.getMessage(exc.key))).build();
    }
}