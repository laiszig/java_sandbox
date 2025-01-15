package com.laiszig.returnvaluesafter.factorial;

import java.math.BigInteger;
import java.util.concurrent.*;

public class CallableFactorialTask implements Callable<BigInteger> {

    private final int value;

    public CallableFactorialTask(int value) {
        this.value = value;
    }

    @Override
    public BigInteger call() throws Exception {
        return factorial(BigInteger.valueOf(value));
    }

    public static BigInteger factorial(BigInteger end) {
        BigInteger start = BigInteger.ONE;
        BigInteger res = BigInteger.ONE;

        for (int i = start.add(BigInteger.ONE).intValue(); i <= end.intValue(); i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res;
    }

    public static BigInteger factorial(BigInteger start, BigInteger end) {
        BigInteger res = start;

        for (int i = start.add(BigInteger.ONE).intValue(); i <= end.intValue(); i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res;
    }
}