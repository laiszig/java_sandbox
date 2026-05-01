package com.laiszig.change_calculator.service;

import com.laiszig.change_calculator.model.Change;
import com.laiszig.change_calculator.model.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Change getChangeDue(PaymentRequest input) {
        return Change.of(input);
    }
}
