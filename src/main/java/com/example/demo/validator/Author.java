package com.example.demo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthorValidator.class)
public @interface Author {
    String message() default "관리자를 사칭할 수 없습니다.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
