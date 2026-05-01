package com.laiszig.change_calculator;

import com.laiszig.change_calculator.model.BillUnit;
import com.laiszig.change_calculator.model.Change;
import com.laiszig.change_calculator.model.Payment;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
public class PaymentTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }


    // VALIDATION TESTS
    @Test
    void shouldPass_whenAmountsAreValid() {
        Payment payment = new Payment();
        payment.setPaid(250);
        payment.setToPay(235);

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldFail_whenAmountsAreInvalid() {
        Payment payment = new Payment();
        payment.setPaid(250);
        payment.setToPay(255);

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertEquals(1, violations.size());
        assertEquals("The amount paid must be >= the amount to pay", violations.iterator().next().getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 300, 'The amount to pay must be greater than 0'",
            "0, 100, 'The amount to pay must be greater than 0'",
            "200, -1, 'The amount paid must be greater than 0'",
            "50, 0, 'The amount paid must be greater than 0'",
    })
    void calculateChange_shouldFailWhenZeroOrNegativeValues(Integer toPay, Integer paid, String expectedMessage) {
        Payment payment = new Payment();
        payment.setToPay(toPay);
        payment.setPaid(paid);

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertEquals(expectedMessage, violations.iterator().next().getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "200, -1, 'The amount paid must be greater than 0'",
            "50, 0, 'The amount paid must be greater than 0'",
    })
    void calculateChange_shouldReturnMoreThanOneError(Integer toPay, Integer paid, String expectedMessage) {
        Payment payment = new Payment();
        payment.setToPay(toPay);
        payment.setPaid(paid);

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertEquals(2, violations.size());
    }

    @Test
    void calculateChange_shouldReturnThreeErrors() {
        Payment payment = new Payment();
        payment.setToPay(0);
        payment.setPaid(-1);

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertEquals(3, violations.size());
    }

    // CHANGE CALCULATION TESTS
    @ParameterizedTest
    @MethodSource("provideExpectedValidResults")
    void calculateChange_shouldReturnChangeDue(Integer toPay, Integer paid, List<BillUnit> expectedResult) {
        Payment payment = new Payment();
        payment.setPaid(paid);
        payment.setToPay(toPay);

        Change change = Change.of(payment);
        assertEquals(expectedResult, change.getChangeDue());
    }

    private static Stream<Arguments> provideExpectedValidResults() {
        return Stream.of(
                arguments(200, 400, List.of(new BillUnit(100, 2))),
                arguments(130, 200, List.of(
                        new BillUnit(50, 1),
                        new BillUnit(20, 1)
                )),
                arguments(378, 400, List.of(
                        new BillUnit(20, 1),
                        new BillUnit(2, 1)
                )),
                arguments(198, 200, List.of(
                        new BillUnit(2, 1)
                )),
                arguments(75, 200, List.of(
                        new BillUnit(100, 1),
                        new BillUnit(20, 1),
                        new BillUnit(5, 1)
                )),
                arguments(33, 100, List.of(
                        new BillUnit(50, 1),
                        new BillUnit(10, 1),
                        new BillUnit(5, 1),
                        new BillUnit(2, 1)
                )),
                arguments(4, 5, List.of()),
                arguments(11, 12, List.of()),
                arguments(0, 0, List.of())
        );
    }

}
