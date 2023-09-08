package com.example.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

// 욕 필터
public class PreventFuxxValidator  implements ConstraintValidator<PreventFuxx, String> {
    List<String> fuxxList = Arrays.asList("씨발", "씨팔", "fuck");

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {

        for (String f : fuxxList) {
            if(field != null && field.contains(f)) {
                return false;
            }
        }

        return true;
    }
}