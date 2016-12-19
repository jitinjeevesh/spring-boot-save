package com.sample.v1.response;

import com.sample.response.AbstractResponse;
import com.sample.response.Response;

public class BloodRequestResponse extends AbstractResponse {
    private String name;
    private String phone;
    private String bloodGroup;

    private BloodRequestResponse(BloodRequestResponseBuilder updateUserResponseBuilder) {
        this.name = updateUserResponseBuilder.name;
        this.phone = updateUserResponseBuilder.phone;
        this.bloodGroup = updateUserResponseBuilder.bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public static class BloodRequestResponseBuilder extends Builder {
        private String name;
        private String phone;
        private String bloodGroup;

        public String getName() {
            return name;
        }

        public BloodRequestResponseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public BloodRequestResponseBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public BloodRequestResponseBuilder setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
            return this;
        }

        public Response build() {
            return new BloodRequestResponse(this);
        }
    }
}
