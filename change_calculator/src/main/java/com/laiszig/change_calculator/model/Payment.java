package com.laiszig.change_calculator.model;

import com.laiszig.change_calculator.validation.ValidAmounts;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ValidAmounts
@NoArgsConstructor
public class Payment {
    @Min(value = 1, message = "The amount to pay must be greater than 0")
    Integer toPay;
    @Min(value = 1, message = "The amount paid must be greater than 0")
    Integer paid;
}
