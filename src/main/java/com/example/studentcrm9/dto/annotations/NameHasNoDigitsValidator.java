package com.example.studentcrm9.dto.annotations;

import com.example.studentcrm9.dto.RegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NameHasNoDigitsValidator implements ConstraintValidator<NameHasNoDigits, RegistrationDto> {
    @Override
    public boolean isValid(RegistrationDto value, ConstraintValidatorContext context) {
        if (checkFirstname(value)) return false;
        if (checkLastname(value)) return false;
        return true;
    }

    private boolean checkFirstname(RegistrationDto value) {
        for (char c : value.firstName().toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    private boolean checkLastname(RegistrationDto value) {
        for (char c : value.lastName().toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}
