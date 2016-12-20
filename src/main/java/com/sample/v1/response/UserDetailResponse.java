package com.sample.v1.response;

import com.sample.response.AbstractResponse;
import com.sample.response.Response;

public class UserDetailResponse extends AbstractResponse {
    private String name;
    private String phone;
    private String bloodGroup;

    private UserDetailResponse(UserDetailResponseBuilder userDetailResponseBuilder) {
        this.name = userDetailResponseBuilder.name;
        this.phone = userDetailResponseBuilder.phone;
        this.bloodGroup = userDetailResponseBuilder.bloodGroup;
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

    public static class UserDetailResponseBuilder extends Builder {
        private String name;
        private String phone;
        private String bloodGroup;

        public String getName() {
            return name;
        }

        public UserDetailResponseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public UserDetailResponseBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public UserDetailResponseBuilder setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
            return this;
        }

        public Response build() {
            return new UserDetailResponse(this);
        }
    }
}
