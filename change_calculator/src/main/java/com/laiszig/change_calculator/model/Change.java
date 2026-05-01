package com.laiszig.change_calculator.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Change {

    private final List<BillUnit> changeDue;
    private final Payment input;

    public static final int[] BILLS = {100, 50, 20, 10, 5, 2};

    private Change(Payment input) {
        this.changeDue = calculateChange(input);
        this.input = input;
    }

    public static Change of(Payment input) {
        return (input == null ? null : new Change(input));
    }

    private List<BillUnit> calculateChange(Payment input) {
        int change = input.getPaid() - input.getToPay();
        List<BillUnit> output = new ArrayList<>();

        for (Integer bill : BILLS) {
            int count = 0;
            while (change >= bill) {
                change -= bill;
                count++;
            }
            if (count > 0) {
                output.add(BillUnit.builder()
                        .bankNote(bill)
                        .amount(count)
                        .build());
            }
        }
        return output;
    }

}
