package com.example.studentcrm9.dto.annotations;

import com.example.studentcrm9.dto.AccountInfoDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NameHasNoDigitsValidator implements ConstraintValidator<NameHasNoDigits, AccountInfoDto> {
    @Override
    public boolean isValid(AccountInfoDto value, ConstraintValidatorContext context) {
        if (firstnameContainsDigit(value)) {
            return false;
        }
        if (lastnameContainsDigit(value)) {
            return false;
        }
        return true;
    }

    private boolean firstnameContainsDigit(AccountInfoDto value) {
        for (char c : value.firstname().toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    private boolean lastnameContainsDigit(AccountInfoDto value) {
        for (char c : value.lastname().toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}
