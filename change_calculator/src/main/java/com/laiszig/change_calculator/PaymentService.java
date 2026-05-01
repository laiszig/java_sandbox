package com.laiszig.change_calculator;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    public List<PaymentOutput> calculateChange(PaymentInput input) {
        List<Integer> values = List.of(100, 50, 20, 10, 5, 2, 1);
        int change = input.getPaid() - input.getToPay();
        Map<Integer, Integer> numberOfBills = new HashMap<>();

        for (Integer value : values) {
            Integer count = 0;
            while (change >= value) {
                change -= value;
                count++;
            }
            numberOfBills.put(value, count);
        }
        return numberOfBills.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(entry -> new PaymentOutput(entry.getKey(), entry.getValue()))
                .toList();

    }
}
