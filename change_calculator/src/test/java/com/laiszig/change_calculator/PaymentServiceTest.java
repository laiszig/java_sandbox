package com.laiszig.change_calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    private PaymentService service;

    @BeforeEach
    void setUp() {
        service = new PaymentService();
    }

    @Test
    void calculateChange_shouldReturnListOfPaymentOutput() {
        PaymentInput input = new PaymentInput();
        input.setPaid(580);
        input.setToPay(350);

        List<PaymentOutput> output = service.calculateChange(input);

        assertEquals(output, List.of(PaymentOutput.builder().amount(1).bankNote(50).build()));
    }



}
