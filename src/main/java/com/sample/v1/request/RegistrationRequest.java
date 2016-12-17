package com.sample.v1.request;

import com.sample.constraints.annotation.StringSize;

import javax.validation.constraints.NotNull;

public class RegistrationRequest implements Request {
    @StringSize(message = "blank.registration.mobile.error.message")
    private String mobileNumber;
    @StringSize(message = "blank.digit.secret.error.message")
    private String dSecret;
    @StringSize(message = "blank.digit.token.error.message")
    private String dToken;
    @NotNull(message = "blank.digit.user.id.error.message")
    private Long dUserId;
    private boolean dIsExpired;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getdSecret() {
        return dSecret;
    }

    public void setdSecret(String dSecret) {
        this.dSecret = dSecret;
    }

    public String getdToken() {
        return dToken;
    }

    public void setdToken(String dToken) {
        this.dToken = dToken;
    }

    public Long getdUserId() {
        return dUserId;
    }

    public void setdUserId(Long dUserId) {
        this.dUserId = dUserId;
    }

    public boolean isdIsExpired() {
        return dIsExpired;
    }

    public void setdIsExpired(boolean dIsExpired) {
        this.dIsExpired = dIsExpired;
    }
}
