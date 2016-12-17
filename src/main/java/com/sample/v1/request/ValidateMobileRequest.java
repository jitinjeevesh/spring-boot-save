package com.sample.v1.request;

import com.sample.constraints.annotation.StringSize;

import javax.validation.constraints.NotNull;

public class ValidateMobileRequest implements Request {
    @NotNull(message = "nullable.registration.mobile.error.message")
    @StringSize(message = "blank.registration.mobile.error.message")
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
