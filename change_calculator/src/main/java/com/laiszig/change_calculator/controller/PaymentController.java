package com.laiszig.change_calculator.controller;

import com.laiszig.change_calculator.model.Change;
import com.laiszig.change_calculator.model.PaymentRequest;
import com.laiszig.change_calculator.model.PaymentResponse;
import com.laiszig.change_calculator.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payment")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PutMapping
    public ResponseEntity<PaymentResponse> pay(@RequestBody PaymentRequest input) {

        Change change = service.getChangeDue(input);

        return ResponseEntity.ok(PaymentResponse.builder().changeDue(change.getChangeDue()).build());
    }
}
