package com.sample.response;

import com.sample.constant.ApplicationConstant;

public class ErrorResponseDTO<T> implements ResponseDTO<T> {
    private Integer code = ApplicationConstant.HTTP_RESPONSE_ERROR_CODE;
    private T data;
    private String message;
    private Integer status = ApplicationConstant.ERROR_STATUS_CODE;

    private ErrorResponseDTO(ErrorResponseBuilder errorResponseBuilder) {
        this.message = errorResponseBuilder.getMessage();
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class ErrorResponseBuilder<T> extends ResponseBuilder<T> {
        @Override
        public ResponseDTO<T> build() {
            return new ErrorResponseDTO<>(this);
        }
    }
}

