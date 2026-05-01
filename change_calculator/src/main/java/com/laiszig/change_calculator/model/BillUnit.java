package com.laiszig.change_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BillUnit {
    Integer bankNote;
    Integer amount;
}
