package com.sample.v1.response;

import com.sample.response.AbstractResponse;

public class RegistrationResponse extends AbstractResponse {
    private boolean validate;
    private String authToken;

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
