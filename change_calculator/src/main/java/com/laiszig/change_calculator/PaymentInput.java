package com.laiszig.change_calculator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentInput {
    Integer toPay;
    Integer paid;
}
