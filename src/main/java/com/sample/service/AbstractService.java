package com.sample.service;

import com.sample.exception.GenericException;
import com.sample.util.CustomExceptionEnum;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class AbstractService {

    public boolean isEmptyMap(Map map) {
        return (isEmptyObject(map) || map.isEmpty());
    }

    public boolean isNotEmptyMap(Map map) {
        return (!isEmptyMap(map));
    }

    public boolean isEmptyObject(Object object) {
        return (object == null);
    }

    public boolean isNotEmptyObject(Object object) {
        return (!isEmptyObject(object));
    }

    public boolean isEmptyList(List list) {
        return (isEmptyObject(list) || list.isEmpty());
    }

    public boolean isNotEmptyList(List list) {
        return !isEmptyList(list);
    }

    public void isValidCondition(Boolean aBoolean, CustomExceptionEnum customExceptionEnum) {
        if (aBoolean) {
            throw new GenericException(customExceptionEnum);
        }
    }

    public void isNullObjectWithException(Object object, CustomExceptionEnum customExceptionEnum) {
        if (object == null) {
            throw new GenericException(customExceptionEnum);
        }
    }

    public void isNullObjectWithException(Object object, String message) {
        if (object == null) {
            throw new GenericException(message);
        }
    }

    public void isEmptyStringWithException(String data, CustomExceptionEnum customExceptionEnum) {
        if (data.isEmpty()) {
            throw new GenericException(customExceptionEnum);
        }
    }


    public void isNullConditionWithException(Boolean aBoolean, CustomExceptionEnum customExceptionEnum) {
        if (aBoolean) {
            throw new GenericException(customExceptionEnum);
        }
    }

    public void compare(int a, int b, CustomExceptionEnum customExceptionEnum) {
        isNullConditionWithException((a != b), customExceptionEnum);
    }

    public void compareDateGreaterThan(Date afterDate, Date beforeDate, CustomExceptionEnum customExceptionEnum) {
        isNullConditionWithException(afterDate.before(beforeDate), customExceptionEnum);
    }
}
