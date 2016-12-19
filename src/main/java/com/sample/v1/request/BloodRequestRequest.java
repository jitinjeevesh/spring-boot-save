package com.sample.v1.request;

import com.sample.constraints.annotation.StringSize;

public class BloodRequestRequest extends AuthenticateRequest {
    @StringSize(message = "blank.blood.request.name.error.message")
    private String contactPerson;
    @StringSize(message = "blank.blood.group.error.message")
    private String bloodGroup;
    private String address;
    private String description;
    private String phoneNumber;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
