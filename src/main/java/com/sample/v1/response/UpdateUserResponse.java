package com.sample.v1.response;

import com.sample.response.AbstractResponse;
import com.sample.response.Response;

public class UpdateUserResponse extends AbstractResponse {
    private String name;
    private String phone;
    private String bloodGroup;

    private UpdateUserResponse(UpdateUserResponseBuilder updateUserResponseBuilder) {
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

    public static class UpdateUserResponseBuilder extends Builder {
        private String name;
        private String phone;
        private String bloodGroup;

        public String getName() {
            return name;
        }

        public UpdateUserResponseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public UpdateUserResponseBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public UpdateUserResponseBuilder setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
            return this;
        }

        public Response build() {
            return new UpdateUserResponse(this);
        }
    }
}
