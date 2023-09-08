package com.example.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.thymeleaf.util.StringUtils;

public class AuthorValidator implements ConstraintValidator<Author, String> {
    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return !StringUtils.equals(field, "관리자");
    }
}
