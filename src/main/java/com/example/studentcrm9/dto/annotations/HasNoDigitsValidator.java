package com.example.studentcrm9.dto.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HasNoDigitsValidator implements ConstraintValidator<HasNoDigits, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (stringContainsDigit(value)) {
            return false;
        }
        return true;
    }
    private boolean stringContainsDigit(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

}
