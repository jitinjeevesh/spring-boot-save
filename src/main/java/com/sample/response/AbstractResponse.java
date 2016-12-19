package com.sample.response;

import org.springframework.validation.BindingResult;

public abstract class AbstractResponse implements Response {

    private BindingResult bindingResult;
    private String successMessage = null;

    @Override
    public Response bindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
        return this;
    }

    @Override
    public BindingResult bindingResult() {
        return this.bindingResult;
    }

    @Override
    public Response successMessage(String message) {
        this.successMessage = message;
        return this;
    }

    public String successMessage() {
        return this.successMessage;
    }

    public abstract static class Builder {
        public abstract Response build();
    }
}
