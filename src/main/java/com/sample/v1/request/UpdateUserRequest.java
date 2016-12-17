package com.sample.v1.request;

import javax.validation.constraints.NotNull;

public class UpdateUserRequest implements Request {
    @NotNull(message = "Name must not be null")
    private String name;
    @NotNull(message = "Mobile number must not be null")
    private String mobileNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
