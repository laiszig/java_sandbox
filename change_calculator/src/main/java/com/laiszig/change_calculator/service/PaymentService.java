package com.laiszig.change_calculator.service;

import com.laiszig.change_calculator.model.Change;
import com.laiszig.change_calculator.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Change processPayment(Payment input) {
        return Change.of(input);
    }
}
