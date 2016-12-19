package com.sample.v1.request;

public class AuthenticateRequest implements Request {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        if (userId != null)
            this.userId = Long.parseLong(userId);
    }
}
