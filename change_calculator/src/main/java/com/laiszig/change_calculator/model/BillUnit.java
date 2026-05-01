package com.laiszig.change_calculator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillUnit {
    Integer bankNote;
    Integer amount;
}
