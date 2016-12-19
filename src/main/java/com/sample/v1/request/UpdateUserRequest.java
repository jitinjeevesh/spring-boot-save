package com.sample.v1.request;

import com.sample.constraints.annotation.StringSize;

public class UpdateUserRequest extends AuthenticateRequest {
    @StringSize(message = "blank.registration.name.error.message")
    private String name;
    @StringSize(message = "blank.blood.group.error.message")
    private String bloodGroup;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
