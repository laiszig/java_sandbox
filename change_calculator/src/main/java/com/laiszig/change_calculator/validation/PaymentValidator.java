package com.laiszig.change_calculator.validation;

import com.laiszig.change_calculator.model.Payment;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PaymentValidator implements ConstraintValidator<ValidAmounts, Payment> {

    @Override
    public void initialize(ValidAmounts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Payment payment, ConstraintValidatorContext context) {
        return payment.getToPay() <= payment.getPaid();
    }
}
