package com.laiszig.change_calculator.controller;

import com.laiszig.change_calculator.model.BillUnit;
import com.laiszig.change_calculator.model.Change;
import com.laiszig.change_calculator.model.Payment;
import com.laiszig.change_calculator.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequestMapping("/payment")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @GetMapping
    public ResponseEntity<List<BillUnit>> pay(@RequestBody @Valid Payment input) {
        Change change = service.processPayment(input);
        return ResponseEntity.ok(change.getChangeDue());
    }
}
