package com.sample.v1.response;

import com.sample.response.AbstractResponse;
import com.sample.response.Response;

import java.util.ArrayList;
import java.util.List;

public class BloodRequestListResponse extends AbstractResponse {
    private List<BloodRequestDetailResponse> bloodRequestDetailResponseList = new ArrayList<>();

    private BloodRequestListResponse(BloodRequestListResponseBuilder bloodRequestListResponseBuilder) {
        this.bloodRequestDetailResponseList = bloodRequestListResponseBuilder.bloodRequestDetailResponseList;
    }

    public List<BloodRequestDetailResponse> getBloodRequestDetailResponseList() {
        return bloodRequestDetailResponseList;
    }

    public void setBloodRequestDetailResponseList(List<BloodRequestDetailResponse> bloodRequestDetailResponseList) {
        this.bloodRequestDetailResponseList = bloodRequestDetailResponseList;
    }

    public static class BloodRequestListResponseBuilder extends Builder {
        private List<BloodRequestDetailResponse> bloodRequestDetailResponseList = new ArrayList<>();

        public List<BloodRequestDetailResponse> getBloodRequestDetailResponseList() {
            return bloodRequestDetailResponseList;
        }

        public BloodRequestListResponseBuilder setBloodRequestDetailResponseList(List<BloodRequestDetailResponse> bloodRequestDetailResponseList) {
            this.bloodRequestDetailResponseList = bloodRequestDetailResponseList;
            return this;
        }

        public BloodRequestListResponseBuilder setBloodRequestDetailResponseList(BloodRequestDetailResponse bloodRequestDetailResponse) {
            this.bloodRequestDetailResponseList.add(bloodRequestDetailResponse);
            return this;
        }

        public Response build() {
            return new BloodRequestListResponse(this);
        }
    }
}
