package com.laiszig.change_calculator;

import com.laiszig.change_calculator.model.BillUnit;
import com.laiszig.change_calculator.model.Change;
import com.laiszig.change_calculator.model.PaymentRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ChangeTest {

    @Test
    void calculateChange_shouldReturnChangeDue() {
        PaymentRequest input = new PaymentRequest();
        input.setPaid(400);
        input.setToPay(350);

        Change change = Change.of(input);
        List<BillUnit> expected = List.of(BillUnit.builder().amount(1).bankNote(50).build());
        assertEquals(expected, change.getChangeDue());

    }

}
