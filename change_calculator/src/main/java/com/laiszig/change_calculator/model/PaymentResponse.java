package com.laiszig.change_calculator.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaymentResponse {
    List<BillUnit> changeDue;
}
