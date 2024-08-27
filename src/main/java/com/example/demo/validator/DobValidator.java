package com.example.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DobValidator implements ConstraintValidator<DobConstraint, LocalDate> {

    private int min;
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext constraintValidatorContext) { // hàm này xử lý data vào có đúng hay không
        if (Objects.isNull(value)) {
            return true;
        }

        long years = ChronoUnit.YEARS.between(value, LocalDate.now());// xác định ngày tháng năm sinh nhập vào cách đây bao nhiêu năm

        return years >= min;
    }

    @Override
    public void initialize(DobConstraint constraintAnnotation) {// khởi tạo khi constraint này khởi tạo
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }
}
