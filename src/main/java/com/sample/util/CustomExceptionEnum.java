package com.sample.util;

public enum CustomExceptionEnum {

    GENERIC_EXCEPTION("GENERIC_EXCEPTION", "exception.generic.message.key");
    private final String key;
    private final String name;

    CustomExceptionEnum(String name, String code) {
        this.name = name;
        this.key = code;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
