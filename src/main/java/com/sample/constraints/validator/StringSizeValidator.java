package com.sample.constraints.validator;

import com.sample.constraints.annotation.StringSize;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringSizeValidator implements ConstraintValidator<StringSize, String> {

    @Override
    public void initialize(StringSize stringSize) {
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext context) {
        return string.length() > 0;
    }
}