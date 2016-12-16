package com.sample.constraints.annotation;

import com.sample.constraints.validator.StringSizeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringSizeValidator.class)
@Documented
public @interface StringSize {

    Class<?>[] groups() default {};

    String message() default "invalid.string.size.message";

    Class<? extends Payload>[] payload() default {};
}