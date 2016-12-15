package com.sample.core.util;

public enum Roles {

    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    IS_FULLY_AUTHENTICATED("IS_FULLY_AUTHENTICATED");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
