package com.sample.v1.request;

import com.sample.constraints.annotation.StringSize;

import javax.validation.constraints.NotNull;

public class RegistrationRequest implements Request {

    @NotNull(message = "nullable.registration.name.error.message")
    private String name;
    @NotNull(message = "nullable.registration.mobile.error.message")
    @StringSize(message = "blank.registration.mobile.error.message")
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
