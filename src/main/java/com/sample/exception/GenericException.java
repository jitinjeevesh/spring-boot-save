package com.sample.exception;

import com.sample.util.CustomExceptionEnum;

public class GenericException extends RuntimeException {

    public String key = CustomExceptionEnum.GENERIC_EXCEPTION.getKey();

    public GenericException() {
    }

    public GenericException(CustomExceptionEnum customExceptionEnum) {
        super();
        key = customExceptionEnum.getKey();
    }

    public GenericException(String message) {
        super(message);
        key = message;
    }
}
