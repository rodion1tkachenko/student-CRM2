package com.example.studentcrm9.dto.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {HasNoDigitsValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface HasNoDigits {
    String message() default "lastname and firstname shouldn't have digits";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
