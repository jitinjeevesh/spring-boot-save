package com.sample.v1.response;

import com.sample.response.AbstractResponse;

public class ValidateMobileResponse extends AbstractResponse {
    private boolean validate;

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
}
