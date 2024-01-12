package com.example.studentcrm9.dto.annotations;

import com.example.studentcrm9.dto.AccountInfoDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NameHasNoDigitsValidator implements ConstraintValidator<NoDigitsInNameAndSurname, AccountInfoDto> {
    @Override
    public boolean isValid(AccountInfoDto value, ConstraintValidatorContext context) {
        if (stringContainsDigit(value.firstname())||stringContainsDigit(value.lastname())) {
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
