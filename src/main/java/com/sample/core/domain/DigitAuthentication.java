package com.sample.core.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DIGIT")
public class DigitAuthentication extends Authentication {

    @Column
    private String secret;
    @Column
    private String token;
    @Column
    private Long digitUserId;

    public DigitAuthentication() {
    }

    private DigitAuthentication(DigitAuthenticationBuilder digitAuthenticationBuilder) {
        this.secret = digitAuthenticationBuilder.secret;
        this.token = digitAuthenticationBuilder.token;
        this.digitUserId = digitAuthenticationBuilder.userId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getDigitUserId() {
        return digitUserId;
    }

    public void setDigitUserId(Long digitUserId) {
        this.digitUserId = digitUserId;
    }

    public static class DigitAuthenticationBuilder extends Builder {

        private String secret;
        private String token;
        private Long userId;

        public String getSecret() {
            return secret;
        }

        public DigitAuthenticationBuilder setSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public String getToken() {
            return token;
        }

        public DigitAuthenticationBuilder setToken(String token) {
            this.token = token;
            return this;
        }

        public Long getUserId() {
            return userId;
        }

        public DigitAuthenticationBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public Authentication build() {
            return new DigitAuthentication(this);
        }
    }
}
