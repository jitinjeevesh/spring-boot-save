package com.sample.v1.request;

import javax.validation.constraints.NotNull;

public class LoginRequest implements Request {
    @NotNull(message = "Name must not be null")
    private String name;
    @NotNull(message = "Mobile number must not be null")
    private Integer mobileNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}