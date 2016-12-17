package com.sample.v1.request;

import com.sample.constraints.annotation.StringSize;

import javax.validation.constraints.NotNull;

public class UpdateUserAfterRegistrationRequest implements Request {

    @StringSize(message = "blank.registration.name.error.message")
    private String name;
    @StringSize(message = "blank.registration.mobile.error.message")
    private String mobileNumber;
    @StringSize(message = "blank.blood.type.error.message")
    private String bloodType;
    private String geocode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGeocode() {
        return geocode;
    }

    public void setGeocode(String geocode) {
        this.geocode = geocode;
    }
}
