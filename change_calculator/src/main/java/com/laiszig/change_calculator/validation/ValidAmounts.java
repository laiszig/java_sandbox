package com.laiszig.change_calculator.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PaymentValidator.class)
public @interface ValidAmounts {

    String message() default "The amount paid must be >= the amount to pay";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
