package com.laiszig.change_calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/payment")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PutMapping
    public ResponseEntity<List<PaymentOutput>> pay (@RequestBody PaymentInput input) {
        return ResponseEntity.ok(service.calculateChange(input));
    }
}
