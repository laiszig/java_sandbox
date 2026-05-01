package com.laiszig.change_calculator.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequest {
    Integer toPay;
    Integer paid;
}
