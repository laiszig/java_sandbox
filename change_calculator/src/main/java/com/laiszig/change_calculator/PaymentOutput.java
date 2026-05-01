package com.laiszig.change_calculator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentOutput {
    Integer bankNote;
    Integer amount;
}
