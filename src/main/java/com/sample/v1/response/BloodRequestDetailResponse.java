package com.sample.v1.response;

import com.sample.response.AbstractResponse;
import com.sample.response.Response;

public class BloodRequestDetailResponse extends AbstractResponse {
    private String name;
    private String phone;
    private String bloodGroup;
    private String description;
    private String address;

    private BloodRequestDetailResponse(BloodRequestDetailResponseBuilder bloodRequestDetailResponseBuilder) {
        this.name = bloodRequestDetailResponseBuilder.name;
        this.phone = bloodRequestDetailResponseBuilder.phone;
        this.bloodGroup = bloodRequestDetailResponseBuilder.bloodGroup;
        this.description = bloodRequestDetailResponseBuilder.description;
        this.address = bloodRequestDetailResponseBuilder.address;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static class BloodRequestDetailResponseBuilder extends Builder {
        private String name;
        private String phone;
        private String bloodGroup;
        private String description;
        private String address;

        public String getName() {
            return name;
        }

        public BloodRequestDetailResponseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public BloodRequestDetailResponseBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getBloodGroup() {
            return bloodGroup;
        }

        public BloodRequestDetailResponseBuilder setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public BloodRequestDetailResponseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public BloodRequestDetailResponseBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Response build() {
            return new BloodRequestDetailResponse(this);
        }
    }
}
