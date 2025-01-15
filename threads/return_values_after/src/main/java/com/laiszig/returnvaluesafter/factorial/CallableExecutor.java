package com.laiszig.returnvaluesafter.factorial;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.*;

public class CallableExecutor {

    public BigInteger execute(List<CallableFactorialTask> tasks) {

        BigInteger result = BigInteger.ZERO;

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        List<Future<BigInteger>> futures;

        try {
            futures = cachedPool.invokeAll(tasks);
        } catch (InterruptedException e) {
            // exception handling example
            throw new RuntimeException(e);
        }

        for (Future<BigInteger> future : futures) {
            try {
                result = result.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                // exception handling example
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}