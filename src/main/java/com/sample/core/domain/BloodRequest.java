package com.sample.core.domain;

import com.sample.core.entity.CommonDataEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "blood_request")
public class BloodRequest extends CommonDataEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = false, name = "requested_by_id")
    @Type(type = "long")
    private User requestedBy;
    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;
    private String description;
    private String address;
    private String phoneNumber;

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
